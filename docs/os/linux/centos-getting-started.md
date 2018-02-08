# Getting Started with CentOS

## Add a new user with sudo privileges

Login as a root user using the default username and password.

```sh
root@osboxes:~# useradd username

root@osboxes:~# usermod -aG wheel username

uid=1001(username) gid=1001(username) groups=1001(username),0(root),10(wheel)

root@osboxes:~# passwd username
Enter new UNIX password:
Retype new UNIX password:
passwd: password updated successfully
```

reference https://www.digitalocean.com/community/tutorials/how-to-create-a-sudo-user-on-centos-quickstart

## Install GIT

yum install git