* Useful URL
http://helpnet.flexerasoftware.com/installshield19helplib/helplibrary/IHelpSetup_EXECmdLine.htm#Ref-Command-LineTools_3873826509_1039936

Array in powershell
https://ss64.com/ps/syntax-arrays.html

Split a string
https://technet.microsoft.com/en-us/library/ee692804.aspx

For loop
https://ss64.com/ps/for.html

Remove-Item
https://codereview.stackexchange.com/questions/90372/delete-folder-if-it-exists-in-powershell
https://social.technet.microsoft.com/Forums/windowsserver/en-US/da4dada1-2845-4efe-830a-d8b9e0b3cbf1/simple-script-to-delete-files-with-progress-bar?forum=winserverpowershell

Run curl from groovy
http://stackoverflow.com/questions/8752965/unable-to-use-curl-within-groovy-script-for-a-rest-put-call

https://stackoverflow.com/questions/1741490/how-to-tell-powershell-to-wait-for-each-command-to-end-before-starting-the-next

Silent install (TDConnect)

-s -as

Restart a windows service from command line:

https://superuser.com/questions/301765/restart-a-windows-service-from-the-command-line\

Check if a port is accessible

I can't see the screenshot with the tests, if you could please re-attach it.
I've discussed this with the CMS networking team and they assured me that there is no port blocking, no network firewall which blocks customer traffic. So the problem is elsewhere.

I've also done some test from VM00003001 (10.240.32.222) to the Test Server (10.56.136.14):



Telnet on port 10000 does indeed not work, but I've tried telnet on port 22 and I see it connects.



Before we try anything else I checked and I can't find any application on vm00003001 that listens on any of those ports (10k,20k,30k). Maybe this is the issue.

Can Paul test to telnet from 10.56.136.14 to vm00003001 on port 22? This port is opened and should connect.


Best regards,

Clipboard manager
http://ditto-cp.sourceforge.net/

Learn Excel
http://www.excel-easy.com/