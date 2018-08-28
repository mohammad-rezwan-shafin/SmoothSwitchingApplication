#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Bootstraping sso_node1 ....."

sudo chown -R vagrant:vagrant /home/vagrant

sudo su - vagrant -c "knife bootstrap sso1.cheftesting.io \
	--ssh-user vagrant --ssh-password 'vagrant' \
	--sudo  sso_node_1 \
	--node-name sso1.cheftesting.io \
	--run-list 'recipe[sso_node]'"
