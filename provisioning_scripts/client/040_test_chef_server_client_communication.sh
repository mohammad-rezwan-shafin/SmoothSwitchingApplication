#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "test_chef_server_client_communication ....."

# sudo chef-server-ctl user-delete opensso

sudo chown -R vagrant:vagrant /home/vagrant

echo -e "$COLOR_SUCCESS"
sudo su - vagrant -c "knife ssl fetch" 2> $TMP_ERR_OUT
sudo su - vagrant -c "knife ssl check" 2>> $TMP_ERR_OUT
echo -e "$COLOR_CLEAR"

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "test_chef_server_client_communication  ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "test_chef_server_client_communication  ..... DONE with Errors."
fi
