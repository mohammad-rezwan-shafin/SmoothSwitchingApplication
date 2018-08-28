#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Starting chef-server_management_console ....."

echo -e "$COLOR_SUCCESS"
sudo chef-manage-ctl start  2> $TMP_ERR_OUT
echo -e "$COLOR_CLEAR"

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Starting chef-server_management_console ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Starting chef-server_management_console ..... DONE with Errors."
fi
