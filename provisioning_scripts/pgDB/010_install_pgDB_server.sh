#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Installing postgresql-server postgresql-contrib ....."

sudo yum install -y postgresql-server postgresql-contrib  2> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Installing postgresql-server postgresql-contrib ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Installing postgresql-server postgresql-contrib ..... DONE with Errors."
fi
