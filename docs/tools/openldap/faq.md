# OpenLDAP FAQ's

## How to generate password for slapd.conf file

```bash
/opt/openldap/sbin/slappasswd
New password:
Re-enter new password:
```

copy the encrypted password and update the slapd.conf file.  
/opt/openldap here, is the install path of openLDAP.

## [ERROR]: BerkeleyDB not available

If you get one of these errors:

* error:BerkeleyDB not available
* error: Berkeley DB version mismatch
* error : Berkeley DB library and header version mismatch

then check if the Berleley Db installation is done correctly. Follow the [installation guide](./install.md) for more details on BDB installation.

Next, export below env varibales before installing OpenLDAP.

```shell
export CPPFLAGS="-I/usr/local/BerkeleyDB.4.8/include"
export LDFLAGS="-L/usr/local/BerkeleyDB.4.8/lib"
export LD_LIBRARY_PATH="/usr/local/BerkeleyDB.4.8/lib/"
```

/usr/local/BerkeleyDB.4.8 here, is the Berkeley DB install path.

_**Reference**_

[Berkeley DB version mismatch](http://lightmaterial.blogspot.nl/2008/04/openldapconfigureberkeley-db-version.html)

## [ERROR]: soelim is required to build OpenLDAP

Install groff package for linux.

```shell
yum install groff -y
```

## [WARNING]: no DB_CONFIG file found in directory /data/openldap

You will get this error while configuring openLDAP if you have not configured a DB_CONFIG file in the data directory.

[DB_CONFIG](./DB_CONFIG) file holds additional configuration for the Berkeley database.