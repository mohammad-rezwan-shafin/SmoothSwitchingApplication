#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Configuring chef-server-core ....."

sudo chef-server-ctl reconfigure --accept-license  2> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Configuring chef-server-core ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Configuring chef-server-core ..... DONE with Errors."
fi
