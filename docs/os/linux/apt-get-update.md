#apt-get update/upgrade

In a nutshell, apt-get update doesn't actually install new versions of software.

**apt-get update** downloads the package lists from the repositories and "updates" them to get information on the newest
versions of packages and their dependencies. It will do this for all repositories and PPAs. 
From http://linux.die.net/man/8/apt-get: Used to re-synchronize the package index files from their sources. The 
indexes of available packages are fetched from the location(s) specified in /etc/apt/sources.list(5). An update should 
always be performed before an upgrade or dist-upgrade.

**apt-get upgrade** will fetch new versions of packages existing on the machine if APT knows about these new versions 
by way of apt-get update. From http://linux.die.net/man/8/apt-get: Used to install the newest versions of all packages 
currently installed on the system from the sources enumerated in /etc/apt/sources.list(5). Packages currently installed 
with new versions available are retrieved and upgraded; under no circumstances are currently installed packages removed,
nor are packages that are not already installed retrieved and installed. New versions of currently installed packages 
that cannot be upgraded without changing the install status of another package will be left at their current version. 
[Emphasis mine] An update must be performed first so that apt-get knows that new versions of packages are available.