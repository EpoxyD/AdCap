# A blatent Adventure Capitalist ripoff

Made with little love for Java EE

## Owners

Evert Borghgraef
Karsten Gielis
Wouter Miewus

## J2EE Glassfish Server

For this Java EE project to run, a J2EE compatible application server needs to be running side by side with the web server

### Install Java JDK

The minimum requirement is Oracle JDK 8 Update 191
For this we have installed Oracle JDK 13

Linux:

- sudo dpkg -i jdk-13_linux-x64_bin.deb

### Install Glassfish Server

The minimum requirement is unknown
For this we have installed Eclipse Glassfish Server 5.1

Linux:

- mkdir ~/Servers
- jar xvf ~/Downloads/glassfish-5.1.0.zip
- mv ~/Downloads/glassfish5 ~/Servers/glassfish5

### Start the Glassfish Server

The default domain is domain1
Linux:

- ~/Servers/glashfish5/bin/asadmin start-domain

### Stop the Glassfish Server

Linux:

- ~/Servers/glashfish5/bin/asadmin stop-domain
