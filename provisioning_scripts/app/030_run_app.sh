#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "running app in background ....."

sudo su - vagrant -c "java -Dspring.profiles.active=vb -jar smooth-switching-application-0.1.0.jar >/dev/null 2> /dev/null & "
