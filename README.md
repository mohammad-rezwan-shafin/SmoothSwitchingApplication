# SmoothSwitchingApplication
Sample SpringBoot Application


Java version - 1.8

Gradle version - 2.9


Java 8 and gradle 2.9 dependencies. Old Project, unfortunately will not work under newer Java version and gradle version.

Sample for OOP/DevOps/Linux Shell Scripts etc.

useful commands

$ vagrant up   (in linux bash or windows git bash shell)
This is do everything setup for dev env DBSetup, schema creation, Linux testing environment etc.

$ gradle clean build flywayClean flywayBaseline flywayMigrate deploy 
This will build the project, deploy the database SQLs and jar to the specific location of the Linux VB.
