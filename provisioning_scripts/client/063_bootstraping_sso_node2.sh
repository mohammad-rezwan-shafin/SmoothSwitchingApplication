#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Bootstraping sso_node2 ....."

sudo chown -R vagrant:vagrant /home/vagrant

sudo su - vagrant -c "knife bootstrap sso2.cheftesting.io \
	--ssh-user vagrant --ssh-password 'vagrant' \
	--sudo  sso_node_2 \
	--node-name sso2.cheftesting.io \
	--run-list 'recipe[sso_node], recipe[sso_node::replication]'"
