# Chocolatey

## Chocolatey

> Easily manage all aspects of Windows software (installation, configuration, upgrade, and uninstallation). Chocolatey is the most reliable when software is included in the package, but can also easily download resources. 

You can install the tool from [here](https://chocolatey.org/install).

Open a **admin** PowerShell shell and do the following:

```bash
Set-ExecutionPolicy AllSigned
Set-ExecutionPolicy AllSigned; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
``` 

## Nexus 3 configuration

Chocolatey uses NuGet, and assuming we want to use outside packages and (potentially our own) we get the following configuration.

* Create internal chocolatey repository (hosted)
* Create proxy to chocolatey gallery (proxy) (remoteStorage: https://chocolatey.org/api/v2)
* Create group repository to combine the two (group)

## Chocolatey Config

```xml
<sources>
        <source id="nexusQAChoco" value="http://q-nexus-3.nl.eu.abnamro.com:8082/repository/chocolatey/" disabled="true" priority="0" />
        <source id="nexusQA" value="http://q-nexus-3.nl.eu.abnamro.com:8082/repository/nuget-group/" disabled="false" priority="1" />
        <source id="chocolatey" value="https://chocolatey.org/api/v2/" disabled="true" priority="2" />
</sources>
```

```bash
choco install googlechrome -y
choco install visualstudiocode -y
choco install sourcetree -y
choco install slack -y
choco install firefox -y
choco install 7zip.install -y
choco install git.install -y
choco install putty -y
choco install keepass -y
choco install gitkraken -y
choco install jdk8 -y
choco install golang -y
choco install maven -y
choco install yarn -y
choco install nodejs.install -y
choco install curl -y
choco install mremoteng -y
choco install conemu -y
```