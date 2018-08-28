#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Create Chef Server opensso user ....."


# sudo chef-server-ctl org-delete cheftestingio
# sudo chef-server-ctl user-delete opensso


echo -e "$COLOR_SUCCESS"
sudo chef-server-ctl user-create opensso System Administrator opensso@server.cheftesting.io 'opensso123' --filename /home/vagrant/opensso.pem  2> $TMP_ERR_OUT
sudo chef-server-ctl org-create cheftestingio 'Chef Testing IO' --association_user opensso --filename /home/vagrant/cheftestingio.pem  2>> $TMP_ERR_OUT
sudo chown vagrant:vagrant /home/vagrant/*.pem 
echo -e "$COLOR_CLEAR"

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Create Chef Server admin user  ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Create Chef Server admin user  ..... DONE with Errors."
fi
