def builders = [:]
for (x in labels) {
    def label = x
    // Create a map to pass in to the 'parallel' step so we can fire all the builds at once
    builders[label] = {
      node(label) {
        // build steps that should happen on all nodes go here
        ws("D:\\maintenance\\cleanup\\${label}"){
            wrap([$class: 'TimestamperBuildWrapper']) {
                stage("Clean ${label}"){
                    checkout scm
                    bat "powershell .\\slave-windows\\maintenance\\solo-clean-sca-nodes.ps1 -Node ${label}"
                    }   
                }
            }
        }
    }
}
parallel builders