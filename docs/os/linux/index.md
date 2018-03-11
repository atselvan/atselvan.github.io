Intro and basic commands:
http://vic.gedris.org/Manual-ShellIntro/1.2/ShellIntro.pdf

Shell in detail
https://bash.cyberciti.biz/guide/Main_Page

Understanding umask
https://www.cyberciti.biz/tips/understanding-linux-unix-umask-value-usage.html

Killing a process
http://stackoverflow.com/questions/6381229/how-to-kill-all-processes-matching-a-name

Getting the username
id -un

Set timezones
http://www.cyberciti.biz/faq/howto-linux-set-time-zone-per-user-basis/

tee command
https://en.wikipedia.org/wiki/Tee_(command)

Linux troubleshot
https://www.tecmint.com/linux-network-configuration-and-troubleshooting-commands/

Server monitoring
http://www.systeen.com/2016/05/07/bash-script-monitor-cpu-memory-disk-usage-linux/
http://www.dbatodba.com/db2/useful-aix-commands/monitor-cpu-mem-and-i-o-usage/

File handlers for a user
* Check hard limit set
    * ulimit -Hn
* Check soft limit set
    * ulimit -Sn
* Check how many file descriptors are being used
    * ls -l | wc -l
    * lsof -p pid

* [SOLUTION] Increase the limit for a particular user
    * 
Linux:
Default open file limit is usually 1024.
To increase this add this to /etc/security/limits.conf (where "nexus" is the UID of the user running Nexus).

#<domain>      <type>  <item>         <value>
#
nexus          hard    nofile          2048
nexus          soft    nofile          2048
Some useful commands:

* Add a existing user to existing group in Unix
    * usermod -a -G jenkins jenkins
* Add a new user to primary group in unix
    * useradd -g jenkins jenkins
* Add home directory to a given user
    * usermod -d /home/jenkins jenkins
* Delete a user 
    * userdel jenkins
* Delete a group
    * groupdel jenkins
* Add a user with specific UID and GID
    * useradd -u 100001 -g 100001 jenkins

* RPM
    * Install a rpm package.
        * rpm -ivh package.rpm
    * Upgrade a rpm package.
        * rpm -Uvh package.rpm
    * Check all the installed rpm packages in the server.
        * rpm -qa
    * Search a specific rpm package installed in the server.
        * rpm -qa | grep package-name

* Cron Jobs for daily backup.
    * http://broexperts.com/2012/06/how-to-backup-files-and-directories-in-linux-using-tar-cron-jobs/
    * http://broexperts.com/2016/02/how-to-setup-linux-crontab-with-examples/

* curl is a tool to transfer data from or to a server, using one of the supported protocols (DICT, FILE, FTP, FTPS, GOPHER, HTTP, HTTPS, IMAP, IMAPS, LDAP, LDAPS, POP3, POP3S, RTMP, RTSP, SCP, SFTP, SMB, SMBS, SMTP, SMTPS, TELNET and TFTP). The command is designed to work without user interaction.

* tree 
    * tree dir -a -L 1
    * -a All files are printed. By default tree does not print hidden files (those beginning with a dot `.'). In no ev-d List directories only.ent does tree print the file system constructs `.' (current directory) and `..' (previous directory).
    * -d List directories only.
    * -s Print the size of each file along with the name.
    * -L level Max display depth of the directory tree.
* 
Find
How do I find all files containing specific text on Linux? 
grep -rnw '/path/to/somewhere/' -e 'pattern'
    * -r or -R is recursive,
    * -n is line number, and
    * -w stands for match the whole word.
    * -l (lower-case L) can be added to just give the file name of matching files.
* Along with these, --exclude, --include, --exclude-dir or --include-dir flags could be used for efficient searching:
    * This will only search through those files which have .c or .h extensions:
grep --include=\*.{c,h} -rnw '/path/to/somewhere/' -e "pattern"
    * This will exclude searching all the files ending with .o extension:
* grep --exclude=*.o -rnw '/path/to/somewhere/' -e "pattern"
    * Just like exclude files, it's possible to exclude/include directories through --exclude-dir and --include-dir parameter. For example, this will exclude the dirs dir1/, dir2/ and all of them matching *.dst/:
* grep --exclude-dir={dir1,dir2,*.dst} -rnw '/path/to/somewhere/' -e "pattern"
This works very well for me, to achieve almost the same purpose like yours.
For more options check man grep
* Find directory except some paths (find unix exclude directories)
    * https://stackoverflow.com/questions/14132210/use-find-command-but-exclude-files-in-two-directories
* RPC bind
    * https://www.redhat.com/archives/redhat-list/2012-February/msg00010.html
    * service rpcbind restart (To restart the service)
    * https://stackoverflow.com/questions/1078524/how-to-specify-the-location-with-wget
    * https://superuser.com/questions/1068031/replace-backslash-with-forward-slash-in-a-variable-in-bash
* Set environment variables
    * https://github.com/sindresorhus/guides/blob/master/set-environment-variables.md
* https://www.shellcheck.net/

netstat -a -n -o | grep "8080"
to find out how to find out which process was using port 8080 and then killed it in Task Manager and then restarted Jenkins and all was well (so far!).

nslookup

Check SSL Handshake

Bitbucket + JIRA

On your production instance perform the following steps
1. Grab the /usr/java/jdk1.8.0_66/jre/lib/security/cacerts file
2. Run the command openssl s_client -connect jira.nl.eu.abnamro.com:443(it's best if you run this on the machine that hosts the production instance of Bitbucket Server)
 I believe that jira.nl.eu.abnamro.com is the FQDN of your production JIRA instance - if that's not correct, use whatever is correct instead