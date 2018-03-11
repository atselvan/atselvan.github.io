import groovy.json.JsonSlurperClassic
import groovy.json.*
import java.util.*
String readJson(text) {
    assert text: 'there is no text present'
    def jsonSlurper = new JsonSlurperClassic()
    def response = jsonSlurper.parseText(text)
    jsonSlurper = null
    echo "response:$response"
    return response
}
node('linux') {
    stage 'getAllRepositories'
    withCredentials([usernamePassword(credentialsId: 'C34398', passwordVariable: 'PASSWD', usernameVariable: 'ID')]) {
   def getAllRepos = """curl \
    -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -X GET \
    -u $ID:$PASSWD \
    https://q-nexus.nl.eu.abnamro.com:8443/nexus/service/local/repositories \
    --tlsv1 > response.out"""
    sh getAllRepos
    def responseText = readFile('response.out').trim()
    def jsonObj = readJson(responseText)
    stage 'Filtering the shared repositories'
    def sharedRepositories = []
    sharedRepositories = getAllSharedRepostries(jsonObj)
    sizeOfList = sharedRepositories.size()
    println("This is the filtered list" +sharedRepositories)
    stage 'deleting the recevied list of shared repositiry'
    for(int i = 0;i < sizeOfList;i++)
    {
    def deleteRepo =  """curl \
    -H "Accept: application/json" \
    -H "Content-Type: application/json" \
    -X DELETE \
    -u $ID:$PASSWD \
    https://q-nexus.nl.eu.abnamro.com:8443/nexus/service/local/repositories/${sharedRepositories[i]} \
    --tlsv1 """
    sh deleteRepo
    println("The requested repository is deleted" +sharedRepositories[i])
    }

}
}
def getAllSharedRepostries(jsonObj)
{
    def sizeOfArray = jsonObj.data.size()
    def listOfSharedRepositories = []
    for(int i = 0; i <=sizeOfArray-1; i++)
    {

        if((jsonObj.data[i].id.indexOf("-shared-releases")>-1) || (jsonObj.data[i].id.indexOf("-shared-snapshots")>-1))
        {   
            println('if condition'+jsonObj.data[i].id + "\n")

            listOfSharedRepositories.add(jsonObj.data[i].id)
        }
    }
    println('This is filtered list' +listOfSharedRepositories)
    return listOfSharedRepositories
}