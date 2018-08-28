#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Bootstraping sso_load_balancer ....."

sudo chown -R vagrant:vagrant /home/vagrant

sudo su - vagrant -c "knife bootstrap sso.cheftesting.io \
    --ssh-user vagrant --ssh-password 'vagrant' \
    --sudo  sso_load_balancer  \
    --node-name sso.cheftesting.io \
    --run-list 'recipe[sso_load_balancer]'"   
