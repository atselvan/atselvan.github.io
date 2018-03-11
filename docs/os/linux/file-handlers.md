* Check hard limit set
    * ulimit -Hn
* Check soft limit set
    * ulimit -Sn
* Check how many file descriptors are being used
    *  ls -l | wc -l
    *  lsof -p pid

* [SOLUTION] Increase the limit for a particular user
    *  
Linux:
Default open file limit is usually 1024.
To increase this add this to /etc/security/limits.conf (where "nexus" is the UID of the user running Nexus).

#<domain>      <type>  <item>         <value>
#
nexus          hard    nofile          2048
nexus          soft    nofile          2048