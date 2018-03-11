# Jenkins Admin Course

## Access control using RBAC

The Role-based Access Control plugin in Jenkins gives a Jenkins administrator the ability to define various security roles that will apply to the system they administer. A role is chiefly a semantic construct forming the basis of access control policy. Once roles have been defined, the Jenkins administrator can assign those roles to groups of users. The assignment of roles can take place either at the global level or can be limited to specific objects within the system. Additionally, the Jenkins administrator can even delegate the management of groups for specific objects to specific users. [read more..](./access-control-rbac.md)

## Jenkins Analytics

CloudBees Jenkins Analytics provide metrics on the usage of agents and masters in a CJOC- managed Jenkins cluster. [read more..](./analytics.md)

## Node Plus

Nodes Plus, available through CloudBees Jenkins Enterprise package, is a plugin designed to allow nodes to have owners. These owners can be notified when a nodes availability changes via email.

Benefits:

* Node owners can be alerted via email on a number of triggers.
* Connected, disconnected, node failure and when the node temporarily goes offline.
* Allows for quick turnaround of build nodes if a failure or disconnect occurs.

## Fast Archiver Plugin

The Fast Archiver plugin uses an rsync-inspired algorithm to transfer archives from agents to a master. The result is that builds complete faster and network bandwidth usage is reduced. [read more..](./fast-archiver.md)

## Even Scheduling Plugin

When using many agent nodes, Jenkins needs to decide where to run any given build. This is called scheduling.

In Jenkins node selection is done in 2 steps:

1. Filter nodes where the build can be executed.
2. One node amongst all the qualifying nodes in (1) must be selected to carry out the build. While (1) is processed by Jenkins core, (2) can be customized by a plugin: this is what the even scheduler plugin does.

[read more..](./even-scheduler-plugin.md)

## Command Line Interface

[read more..](./command-line-interface.md)