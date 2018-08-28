#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Installing chefdk-1.2.20-1.el7.x86_64.rpm ....."

sudo rpm -ivh /vagrant/.installers/chefdk-1.2.20-1.el7.x86_64.rpm  2> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Installing chefdk-1.2.20-1.el7.x86_64.rpm ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Installing chefdk-1.2.20-1.el7.x86_64.rpm ..... DONE with Errors."
fi
