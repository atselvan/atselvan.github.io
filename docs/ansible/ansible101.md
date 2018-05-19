# Running some Ansible command

To start learning ansible you need some space virtual machines to get started and trigger your command on.

You can easily avail them by using Virtual box. But spinning-up/destroying a server on virtual box manually can be time consuming.

To add a level of automation to this you can use the combination of Virtual box and vagrant.

!!! warning "I am asuming that you have virtual box and vagrant installed on your host system"

## Create a ssh key

```bash
ssh-keygen -t rsa -C "ansible"
```

```bash
Generating public/private rsa key pair.
# Enter the path ./id_rsa to store it at the current location
Enter file in which to save the key (/Users/allanselvan/.ssh/id_rsa): ./id_rsa
# Leave the passphrase empty
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in ./id_rsa.
Your public key has been saved in ./id_rsa.pub.
The key fingerprint is:
SHA256:Ib5jUXjsbd5eDNDoLKw9qzhbJPoh17VAfYH2CnYJV/k ansible
The key's randomart image is:
+---[RSA 2048]----+
|         oo.     |
|      .++ .+     |
|      ++*o+..    |
|     oo*o*..E    |
|    ..=oS.= .    |
|   . + B.= . o   |
|  o o B + . . o  |
|   +.= . o . .   |
|    +o...   .    |
+----[SHA256]-----+
```

thus, in your current directory you should have the below set of files

```ini
-rw-r--r--  1 allanselvan  staff   139B May 19 08:53 README.md
-rw-------  1 allanselvan  staff   1.6K May 19 09:40 id_rsa
-rw-r--r--  1 allanselvan  staff   389B May 19 09:40 id_rsa.pub
-rw-r--r--  1 allanselvan  staff   2.0K May 19 09:47 Vagrantfile
-rw-r--r--  1 allanselvan  staff   117B May 19 10:00 hosts
```

!!! warning "Never commit ssh keys to git"

## Create a vagrant file

Vagrant is used to spin up the virtual machines required for running some ansible commands

filename: Vagrantfile

```bash
# encoding: utf-8
# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
config.vm.box = "centos/7"
config.vm.provider "virtualbox" do |v|
  v.memory = 1024
end

$provision = <<PROVISION
sudo su -
yum update -y
yum install httpd -y
service httpd start
echo "This is my test Jenkins system" > /var/www/html/index.html
PROVISION

$installAnsible = <<Ansible
sudo su -
yum update -y
yum install ansible -y
Ansible

config.vm.define "jenkins" do |jenkins|
  jenkins.vm.box = "centos/7"
  config.vm.provider "virtualbox" do |v|
    v.name = "jenkins"
  end
  jenkins.vm.hostname = "jenkins"
  jenkins.vm.network "private_network", ip: "192.168.1.80"
  jenkins.vm.network "forwarded_port", guest: 8080, host: 8080
  jenkins.vm.network "forwarded_port", guest: 22, host: 2201, id: "ssh"
  jenkins.vm.provision "shell", inline: $provision
  jenkins.vm.provision "file", source: "./id_rsa.pub", destination: "~/.ssh/id_rsa.pub"
  jenkins.vm.provision "shell", inline: "cat ~vagrant/.ssh/id_rsa.pub >> ~vagrant/.ssh/authorized_keys"
end

config.vm.define "nexus" do |nexus|
  nexus.vm.box = "centos/7"
  config.vm.provider "virtualbox" do |v|
    v.name = "nexus"
  end
  nexus.vm.hostname = "nexus"
  nexus.vm.network "private_network", ip: "192.168.1.81"
  nexus.vm.network "forwarded_port", guest: 8081, host: 8081
  nexus.vm.network "forwarded_port", guest: 22, host: 2202, id: "ssh"
  nexus.vm.provision "shell", inline: $provision
  nexus.vm.provision "file", source: "./id_rsa.pub", destination: "~/.ssh/id_rsa.pub"
  nexus.vm.provision "shell", inline: "cat ~vagrant/.ssh/id_rsa.pub >> ~vagrant/.ssh/authorized_keys"
end

config.vm.define "ansible" do |ansible|
  ansible.vm.box = "centos/7"
  config.vm.provider "virtualbox" do |v|
    v.name = "ansible"
  end
  ansible.vm.hostname = "ansible"
  ansible.vm.network "private_network", ip: "192.168.1.83"
  ansible.vm.network "forwarded_port", guest: 22, host: 2203, id: "ssh"
  ansible.vm.provision "shell", inline: $installAnsible
  ansible.vm.provision "file", source: "./id_rsa", destination: "~/.ssh/id_rsa"
end

end
```

As part of the vagrant setup the ssh key is configured on all the three servers so that the ansible machine is able to ssh to the jenkins and nexus machines.

!!! warning "Make sure the ssh key you created is stored parallel to your Vagrantfile before you execute the vagrant up command."

!!! info "Vagrant commands"

    Run ```vagrant up``` to run the virtual machines

    Run ```vagrant destroy -f``` if you wish to destroy the virtual machines

    Run ```vagrant provision``` to provision the virtual machines

    Run ```vagrant ssh vagrant_box_name``` to ssh connect into a machine

## Create the ansible inventory file

filename: hosts

```ini
[jenkins]
192.168.1.80

[nexus]
192.168.1.81

[all:vars]
ansible_user=vagrant
ansible_ssh_private_key_file=./id_rsa
```

As my private key is not in the default path ~/.ssh I have also configure the path to the private key file in my inventory to establish a successful connection to the target machines.

## Run your first command

!!! info
    If you have ansible installed on your host machine you can run the commands from your host machine itself.

    But if you don't! No worries! You can ssh into the ansible machine ```vagrant ssh ansible```, browse to the /vargrant directory (the directory of your Vagrantfile is automatically copied to the /vagrant directory of your vagrant boxes) and then run your ansible commands

```bash
# check if you are able to connect to all the hosts in your inventory
ansible all -i hosts -m ping

output:
192.168.1.80 | SUCCESS => {
    "changed": false,
    "ping": "pong"
}
192.168.1.81 | SUCCESS => {
    "changed": false,
    "ping": "pong"
}
```

## Try out some more commands

```bash
# run the uptime command on all the hosts in the jenkins group
ansible jenkins -i hosts -m command -a uptime

output:
192.168.1.80 | SUCCESS | rc=0 >>
 20:34:21 up  1:05,  1 user,  load average: 0.00, 0.01, 0.05
```

```bash
# run the hostname command on all the hosts in the inventory
ansible all -i hosts -m command -a hostname

output:
192.168.1.80 | SUCCESS | rc=0 >>
jenkins

192.168.1.81 | SUCCESS | rc=0 >>
nexus
```

```bash
# gather information about your local machine
ansible localhost -m setup
```

```bash
# gather information about all the hosts in your inventory
ansible all -i hosts -m setup
```

```bash
# install git package on all the hosts in the inventory as a root user
ansible all -i hosts -m yum -a "name=git state=present" --become-user root -b

# for installing git with yum you need to escalate your rights to root, for doing this -b and -become-user=root arguments are used

# check the installation by ssh-ing into the vagrant box
vagrant ssh jenkins

# check if git exists
git version

output:
git version 1.8.3.1
```

```bash
# install docker package on all the hosts in the inventory as a root user
ansible all -i hosts -m yum -a "name=docker state=present" --become-user root -b

# check the installation by ssh-ing into the vagrant box
vagrant ssh nexus

# check if git exists
docker version

output:
Client:
 Version:         1.13.1
 API version:     1.26
```

```bash
# install httpd package on all the hosts in the inventory as a root user
ansible all -i hosts -m yum -a "name=httpd state=present"

# hhtpd already exists on the hosts hence you would get the below message

output:
192.168.1.80 | SUCCESS => {
    "changed": false,
    "msg": "",
    "rc": 0,
    "results": [
        "httpd-2.4.6-80.el7.centos.x86_64 providing httpd is already installed"
    ]
}
192.168.1.81 | SUCCESS => {
    "changed": false,
    "msg": "",
    "rc": 0,
    "results": [
        "httpd-2.4.6-80.el7.centos.x86_64 providing httpd is already installed"
    ]
}
```