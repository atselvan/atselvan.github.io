* Using Groovy LDAP
    * https://dzone.com/articles/programming-ldap-groovy
    * https://hhendriks.wordpress.com/2012/04/13/using-groovy-to-connect-to-active-directory/
* Where to find?
    * https://svn.apache.org/repos/asf/directory/sandbox/szoerner/groovyldap/
    * http://repository.apache.org/snapshots/org/apache/directory/groovyldap/



import org.apache.directory.groovyldap.LDAP

//Technical user variables
  def cnvar_techuser = "$projName" + "_BUILDER"
  def DNvar_techuser = "uid=" + "$projName" + "_BUILDER" + ",ou=users,o=sccm"
  def pass_techuser = "welcome" +  "$projName"

//Add Technical User for the Project
  def techuseradd_attr = [
  objectclass : ['inetOrgPerson', 'organizationalPerson', 'top', 'person'],
  sn : ' $projName ',
  cn : 'Technical User',
  mail : ' $projName @nl.abnamro.com',
  uid : (cnvar_techuser).toString(),
  userPassword:  ( pass_techuser ).toString(),
  ];

//Add Technical user to LDAP
  if (!ldap.exists("$DNvar_techuser"))
  ldap.add("$DNvar_techuser", techuseradd_attr);

import org.apache.directory.groovyldap.LDAP