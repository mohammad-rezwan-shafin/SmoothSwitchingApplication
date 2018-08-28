#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Upload Cookbooks ....."

sudo chown -R vagrant:vagrant /home/vagrant

echo -e "$COLOR_SUCCESS"
sudo su - vagrant -c "knife cookbook upload sso_load_balancer" 
sudo su - vagrant -c "knife cookbook upload sso_node" 
echo -e "$COLOR_CLEAR"

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
   printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Upload Cookbooks  ..... DONE."
else
   printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Upload Cookbooks  ..... DONE with Errors."
fi
