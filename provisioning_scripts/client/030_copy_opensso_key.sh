#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Copy opensso key ....."

# sudo chef-server-ctl user-delete opensso

echo -e "$COLOR_SUCCESS"
cp -v /vagrant/pem_files/opensso.pem /home/vagrant/  2> $TMP_ERR_OUT
echo -e "$COLOR_CLEAR"

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Copy opensso key  ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Copy opensso key  ..... DONE with Errors."
fi
