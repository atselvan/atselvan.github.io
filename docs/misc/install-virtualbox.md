# Install Virtual Box

 VirtualBox is a powerful x86 and AMD64/Intel64 virtualization product for enterprise as well as home use. Not only is VirtualBox an extremely feature rich, high performance product for enterprise customers, it is also the only professional solution that is freely available as Open Source Software under the terms of the GNU General Public License (GPL) version 2.

## Download Virtual box

* [Virtual Box for windows][vb]  
* [Extension pack for Virtual box][vbe]

## Install virtual box in windows

* Double click on the downloaded exe file and follow the instructions

## Install VirtualBox Extension Pack

* Launch Virtual box

* From VirtualBox main window, go to File->Preferences. This will open VirtualBox Preferences window. Navigate to extension as shown in the picture below.

  ![Alt text](images/install-virtualbox-file-preferences.png)

* Next, click on the small down arrow on the right side of the window (as indicated in the above picture). Navigate and  select the Extension Pack you downloaded. 

  ![Alt text](images/install-virtualbox-file-preferences-browse.png)

* You will be asked to confirm VirtualBox Extension Pack setup. Confirm and install the extension pack.

  ![Alt text](images/install-virtualbox-extensions-installed.png)

## Useful links:

* https://www.howtogeek.com/124622/how-to-enlarge-a-virtual-machines-disk-in-virtualbox-or-vmware/
* https://howtobi.wordpress.com/2010/10/30/adding-a-additional-hard-disk-in%C2%A0virtualbox/
* https://www.groovypost.com/howto/virtualbox-error-uuid-hard-disk/

[vb]: http://download.virtualbox.org/virtualbox/5.1.18/VirtualBox-5.1.18-114002-Win.exe
[vbe]: http://download.virtualbox.org/virtualbox/5.1.18/Oracle_VM_VirtualBox_Extension_Pack-5.1.18-114002.vbox-extpack

## Linux

```sh
# Download the install package
wget http://download.virtualbox.org/virtualbox/5.1.22/virtualbox-5.1_5.1.22-115126~Ubuntu~xenial_amd64.deb
# Install the package
sudo dpkg -i virtualbox-5.1_5.1.22-115126~Ubuntu~xenial_amd64.deb
# Cleanup
rm -rf virtualbox-5.1_5.1.22-115126~Ubuntu~xenial_amd64.deb
```
