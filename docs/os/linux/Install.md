sudo apt-get update

Added a hostname ci.ats.in

sudo apt-get -y install curl openssh-server openssh-client

To check the linux distribution run the below command:
lsb_release -c

VIM
sudo apt-get -y install vim

Google Chrome
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
dpkg -i google-chrome*.deb
rm -rf google-chrome-stable_current_amd64.deb

GIT
apt-get -y install git

dos2unix
sudo apt-get install dos2unix

Visual Studio Code
Download from https://go.microsoft.com/fwlink/?LinkID=760868
sudo dpkg -i code_1.13.1-1497464373_amd64.deb
rm -rf code_1.13.1-1497464373_amd64.deb

Get started : https://code.visualstudio.com/docs?start=true

udo add-apt-repository "deb http://us.archive.ubuntu.com/ubuntu/ saucy universe multiverse"

MySql Workbench

sudo apt-get -y install mysql-workbench

Oracle JDK 8

sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get -y install oracle-java8-installer

Mount a ntfs drive

https://ubuntuforums.org/showthread.php?t=1880423

UUID=9ADAD28CDAD26453 /data     ntfs    defaults    0       0

sudo apt-get install deluge

Keypass

apt-add-repository ppa:jtaylor/keepass
sudo apt-get update
apt-get -f install
sudo apt-get install keepass2
