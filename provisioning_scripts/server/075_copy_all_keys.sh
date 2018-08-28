#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Copy all keys ....."

# sudo chef-server-ctl user-delete opensso

echo -e "$COLOR_SUCCESS"
cp -v /home/vagrant/*.pem /vagrant/pem_files 2> $TMP_ERR_OUT
echo -e "$COLOR_CLEAR"

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Copy all keys  ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Copy all keys  ..... DONE with Errors."
fi
