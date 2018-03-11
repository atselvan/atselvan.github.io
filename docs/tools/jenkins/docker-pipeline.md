node('docker') {
        

        try {
            stage('Prepare'){

               parallel (
                    Clean: {
                        deleteDir()
                    },
                    CheckOut: {
                        sh 'git clone https://10.240.2.246:7999/scm/~c29874/maven-assembly-example.git'
                    }, 
                    WriteSettingsXml: {
                        writeSettingsXml('SOLO')
                    }
                )
            }

            stage('Build'){
                dir('maven-assembly-example') {
                    docker.image('maven:3.3.3-jdk-8').inside {
                        sh 'mvn clean package -s ../settings.xml -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true'
                    }
                }
            }
        } finally {
            stage('Cleanup') {
                step([$class: 'WsCleanup'])
            }
        }

    }
}

def writeSettingsXml(String CODE) {
    def releasesMirror = """
    <mirror>
        <id>${CODE}-Mirror</id>
        <mirrorOf>central</mirrorOf>
        <name>${CODE}-Mirror</name>
        <url>https://10.240.12.25:8443/nexus/content/groups/${CODE}-releases-virtual/
        </url>
    </mirror>
    """
    writeFile encoding: 'UTF-8', file: 'settings.xml', text: """
    <settings>
        <mirrors>
            ${releasesMirror}
        </mirrors>
    </settings>
    """

}