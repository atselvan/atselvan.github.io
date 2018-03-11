Below is the policies currently set:

System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-scripts allow-popups allow-same-origin; default-src 'self'; script-src 'self'  'unsafe-inline';img-src 'self'; style-src 'self' 'unsafe-inline';")
-Dhudson.model.DirectoryBrowserSupport.CSP="sandbox allow-scripts ; default-src 'self'; script-src 'self';img-src 'self'; style-src 'self' 'unsafe-inline';"

Set a custom value for the header:
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox; default-src 'self';")
Unset the header:
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")
Set the header to the default:
System.clearProperty("hudson.model.DirectoryBrowserSupport.CSP")
Find out the current header value:
System.getProperty("hudson.model.DirectoryBrowserSupport.CSP")