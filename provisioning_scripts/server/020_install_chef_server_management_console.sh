#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Installing chef-manage-2.4.4-1.el7.x86_64.rpm ....."

sudo rpm -ivh /vagrant/.installers/chef-manage-2.4.4-1.el7.x86_64.rpm  2> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Installing chef-manage-2.4.4-1.el7.x86_64.rpm ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Installing chef-manage-2.4.4-1.el7.x86_64.rpm ..... DONE with Errors."
fi
