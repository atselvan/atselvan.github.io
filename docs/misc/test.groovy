import groovy.json.JsonSlurper;

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{ "name": ["John Doe","Allan Selvan","John Doe","Allan Selvan"],"age":["20",' +
        '"24","20","24"] }  ')

//assert object instanceof Map
for(def i=0;i<object.name.size();i++) {
    printf(object.name[i] + "\n" + object.age[i] + "\n")
}

def get = new URL("http://httpbin.org/get").openConnection();
def getRC = get.getResponseCode();
println(getRC);
if(getRC.equals(200)) {
    println(get.getInputStream().getText());
}

// POST
def post = new URL("http://httpbin.org/post").openConnection();
def message = '{"message":"this is a message"}'
post.setRequestMethod("POST")
post.setDoOutput(true)
post.setRequestProperty("Content-Type", "application/json")
post.getOutputStream().write(message.getBytes("UTF-8"));
def postRC = post.getResponseCode();
println(postRC);
if(postRC.equals(200)) {
    println(post.getInputStream().getText());
}

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')
import static groovyx.net.http.ContentType.TEXT

def client = new groovyx.net.http.HTTPBuilder('myRestFulURL')
client.setHeaders(Accept: 'application/json')

def json = client.get(contentType: TEXT)
def slurper = new groovy.json.JsonSlurper().parse(json)