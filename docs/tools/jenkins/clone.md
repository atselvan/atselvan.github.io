* Make both primary and secondary instance active with the same configuration.

STEPS

[07-07-2016]
* Release both the masters from Jenkins Ops centre.
* Release all the build servers from Jenkins Ops centre.
* Stop Jenkins master 2.
* Started working on Jenkins master 1.
    * Make the configuration of jenkins ET almost similar to Jenkins PR.
[08-07-2016]
* Continuing work on Jenkins master 1.
    * Install the License again.
    * Configure Jenkins to use security via SLU LDAP.
        * User access is disabled for now.
    * Both the build servers are added to Jenkins Master 1 with two executors each.
        * Build servers are added as a service.
        * Deleted unwanted Build server services and workspaces from the server.
    * Changing the home path naming from jenkins to jenkins-M1.
    * Rechecked the configuration and made some changes that were not same as PR.
* Clone master 1 to master 2.
    * Make a copy of jenkins master 1 and rename home path as jenkins-M2.
    * Delete the files listed below:
        * $JENKINS_HOME/secret.key*
$JENKINS_HOME/license.xml
$JENKINS_HOME/identity.key.enc
$JENKINS_HOME/jgroups/
    * Delete JOC configuration files.
        * $JENKINS_HOME/operations-center-cloud*
$JENKINS_HOME/operations-center-client*
$JENKINS_HOME/com.cloudbees.opscenter.client.plugin.OperationsCenterRootAction.xml
    *  Remove any slave connections and generate new connections to them. You can do this by just removing them from $JENKINS_HOME/nodes and removing the contents of $JENKINS_HOME/jgroups
    * Start the master 2 instance.
    * Activate the instance by using the license.
        * Have requested cloudbees for the license.
    * The master 2 instance is up and running.
    * Starting the Build servers as a service.
[18-07-16]
* Started working on Jenkins Master 2 production instance.
* Coped jenkins master 1 data to a new directory jenkins-M2 under the nfs drive.
    * No need to copy the jobs directory.
* Delete the files listed below:
    * $JENKINS_HOME/secret.key*
$JENKINS_HOME/license.xml
$JENKINS_HOME/identity.key.enc
$JENKINS_HOME/jgroups/
* Delete JOC configuration files.
    * $JENKINS_HOME/operations-center-cloud*
           $JENKINS_HOME/operations-center-client*
           $JENKINS_HOME/com.cloudbees.opscenter.client.plugin.OperationsCenterRootAction.xml
* Remove any slave connections and generate new connections to them. You can do this by just removing them from $JENKINS_HOME/nodes and removing the contents of $JENKINS_HOME/jgroups
* Start the master 2 instance.
* Activate the instance by using the license.
* Change the jenkins url in the configuration page.
* Configure jenkins security with LDAP.
* 

ERROR
* Once released from JOC, JCE license was not installed in the instances anymore and LDAP configuration was disabled.
    * [Fix] license was installed again and LDAP was reconfigured.
* LDAP is not configured as a secure connection using LB url.
    * Need to check this.
* Once Jenkins master 1 was cloned to Jenkins master 2 the instance ID of master 2 was changed and new license had to be requested.
TO DO
* Create a document explaining the current build server configuration in Jenkins.
* Create a document for Master clone process.