#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Installing java-1.8.0-openjdk-devel ....."

sudo yum install -y java-1.8.0-openjdk-devel 2> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Installing java-1.8.0-openjdk-devel ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Installing java-1.8.0-openjdk-devel ..... DONE with Errors."
fi
