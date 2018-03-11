# Installing OpenLDAP server

OpenLDAP has a dependency on Oracle's Berkeley DB hence we need to first install berkeley db.

## Prerequisite

Make sure gcc, gcc-c++, make and other required packages are available on the server.

Run the below command : to confirm and if not available install them.

```shell
yum update -y \
yum install unzip gcc gcc-c++ make -y groff
```

## Installing Berkeley Db

Copy paste the below code into a shell script and execute it. Change the BDB_VERSION variable if you want to install a different version.

```shell
BDB_VERSION="4.8.30"
curl -o db-${BDB_VERSION}.zip -fSL http://download.oracle.com/berkeley-db/db-${BDB_VERSION}.zip \
unzip db-${BDB_VERSION}.zip \
cd ./db-${BDB_VERSION}/build_unix \
../dist/configure --enable-cxx \
make \
make install
```

## Installing OpenLDAP

Export below env variable

```shell
export CPPFLAGS="-I/usr/local/BerkeleyDB.4.8/include"
export LDFLAGS="-L/usr/local/BerkeleyDB.4.8/lib"
export LD_LIBRARY_PATH="/usr/local/BerkeleyDB.4.8/lib/"
```

Copy paste the below code into a shell script and execute it. Change the INSTALL_PATH if you wish to install in another path and OPENLDAP_VERSION if you want to install a different version. Make sure that the OpenLDAP version and the Berkeley Db version are compatible.

```shell
INSTALL_PATH="/opt/openldap"
OPENLDAP_VERSION='2.4.45'

curl -o openldap-${OPENLDAP_VERSION}.tgz -fSL https://www.openldap.org/software/download/OpenLDAP/openldap-release/openldap-${OPENLDAP_VERSION}.tgz \
tar -xzvf openldap-${OPENLDAP_VERSION}.tgz \
ls -lrt \
./openldap-${OPENLDAP_VERSION}/configure --prefix="${INSTALL_PATH}" \
    --enable-slapd \
    --enable-bdb \
    --enable-overlays \
    --enable-syslog \
    --enable-accesslog \
    --enable-auditlog \
    --enable-dynlist \
    --enable-ppolicy \
    --enable-memberof \
    --enable-constraint \
    --enable-debug \
make depend \
make \
make install
```