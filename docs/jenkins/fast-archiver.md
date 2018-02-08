# Fast Archiver Plugin

The Fast Archiver plugin uses an rsync-inspired algorithm to transfer archives from agents to a master. The result is that builds complete faster and network bandwidth usage is reduced.

**PS:** The Fast Archiver plugin is automatically installed and enabled if you have downloaded. CloudBees Jenkins Enterprise. This plugin takes over the built-in artifact archiving functionality in Jenkins. If you are already using that feature, no configuration change is needed to take advantages of this feature.

**Notes:** Fast archiving only works in the context of a distributed architecture, where jobs do not run on the same machine as the Jenkins master. Fast archiving needs existing artifacts from previous builds in order to compare with the new artifact and perform an incremental update. Otherwise, it will perform a complete artifact transfer. It will also perform a complete transfer if the fast archiver detects that data is corrupted due to an internal bug.
