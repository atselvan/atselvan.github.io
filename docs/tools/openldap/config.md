# Configuring OpenLDAP server

## slapd.conf file

slapd.conf file holds all the configuration required for running the openLDAP server. Below is a example of the slapd.conf file.

```shell
###### PrivateSquare.in slapd config file ############
#
# NOTES: inetorgperson picks up attributes and objectclasses
#        from all three schemas
#
include         /opt/openldap/etc/openldap/schema/core.schema
include         /opt/openldap/etc/openldap/schema/cosine.schema
include         /opt/openldap/etc/openldap/schema/inetorgperson.schema
include         /opt/openldap/etc/openldap/schema/dyngroup.schema

# NO SECURITY - no access clause
# defaults to anonymous access for read
# only rootdn can write

#access to *
# by anonymous none
# by * write

# NO REFERRALS

# DON'T bother with ARGS file unless you feel strongly
# slapd scripts stop scripts need this to work
pidfile     /opt/openldap/run/slapd.pid
argsfile    /opt/openldap/run/slapd.args

# enable a lot of logging - we might need it
# but generates huge logs
loglevel        -1

# NO TLS-enabled connections

####################################################################
### Create configuration DIT in OpenLdap
###
### NOTE: the suffix is hardcoded as cn=config and
### MUST not have a suffix directive
### normal rules apply - rootdn can be anything you want
### but MUST be under cn=config
#######################################################################
database config
rootdn "cn=root,cn=config"
rootpw {SSHA}GT4+O2DLvYfJTqAM7VFIGCiY+Q+fGcgr

# Private Square database -----------------------------

database bdb
suffix "dc=privatesquare,dc=in"

overlay dynlist
dynlist-attrset groupOfURLs memberURL owner

# root or superuser
rootdn "cn=root,dc=privatesquare,dc=in"
rootpw {SSHA}GT4+O2DLvYfJTqAM7VFIGCiY+Q+fGcgr
# # The database directory MUST exist prior to running slapd AND
# # change path as necessary
directory       /data/openldap

index   objectClass     eq
index   uid     eq
index   cn,gn,mail eq,sub
index sn eq,sub
index ou eq

cachesize 10000
checkpoint 128 15
```

/opt/openldap is the install path of openLDAP and /data/openldap is the data path for the private square db.

## Building the Config Db

Below command builds the config db based on the entries in the slapd.conf file. The config db will be built into the path ${INSTALL_PATH}/etc/openldap/slapd.d

```bash
cd ${INSTALL_PATH}
./sbin/slaptest -f ./etc/openldap/slapd.conf -F ./etc/openldap/slapd.d -u
```

## Building the Data Db

For building the data db you need to import the initial LDAP structure you prefer.

This is the entry I need for the private squate db.

```ldif
# Initial root entry for privatesquare.in

dn: dc=privatesquare,dc=in
objectClass: top
objectClass: domain
dc: privatesquare
```

touch the contents of the ldif into a initial.ldif file and run the below command to build the data db.

```bash
cd ${INSTALL_PATH}
./sbin/slapadd -q -l [Path to the initail ldif file] -f ./etc/openldap/slapd.conf
```

## Testing the configuration

Test the configuration by running the below command.

```bash
cd ${INSTALL_PATH}
./sbin/slaptest -f ./etc/openldap/slapd.conf -F ./etc/openldap/slapd.d
```

## Start OpenLDAP

```bash
cd ${INSTALL_PATH}
./libexec/slapd -h "ldap://hostname:port"  -f ./etc/openldap/slapd.conf
```