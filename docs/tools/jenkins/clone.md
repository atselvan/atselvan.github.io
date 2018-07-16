# Cloning a Jenkins Master instance

In my experience with Jenkins, too many jobs on a single Jenkins master can lead to lots if performance issues on the master and as Jenkins cannot be scaled horizontally the only option that remains is to split the jobs on a single master into multiple identical instances.

But if you have a very big jenkins instance with many plugins and configurations linked to each plugin on the master it can be very time consuming to install multiple masters and then configure the same. It can be a nightmare as most of the jenkins configuration cannot be automated.

Below steps explain how a master can be cloned to ensure that all the settings and configuration is identical to the existing master.  

!!! note
    below steps asumes that you have a Cloudbees Jenkins Operations Center (CJOC) to which the master is connected to. If this is not the case then you can ignore the steps in which CJOC is mentioned.

## Steps for cloning a Jenkins Master

1. Release the existing master from CJOC.
2. Install a second instance of Jenkins for scaling up the cluster.
3. Copy the existing jenkins master's home path into the home path of the new master. You can skip the jobs directory during the copy.
4. Delete the files/directories listed below from the home path of the new master.
    
    * $JENKINS_HOME/secret.key*
    * $JENKINS_HOME/license.xml
    * $JENKINS_HOME/identity.key.enc
    * $JENKINS_HOME/jgroups/

5. Delete JOC configuration files from the home path of the new master.

    * $JENKINS_HOME/operations-center-cloud*
    * $JENKINS_HOME/operations-center-client*
    * $JENKINS_HOME/com.cloudbees.opscenter.client.plugin.OperationsCenterRootAction.xml

6. Delete all the pinned plugins from the plugins directory in the new master's home path.

    ```bash
    rm -rf ${NEW MASTER HOME}/plugins/*.pinned
    ```

7. Starte the new master instance and configure the license.
8. Change the Jenkins URL in `Manage Jenkins -> Configure System` with the URL of the new master.
9. Connect both the masters with CJOC.
10. If all the steps are completed you will have two identical jenkins masters