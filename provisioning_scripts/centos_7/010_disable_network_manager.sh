#!/bin/sh
# 
# File:   02_add_all_new_hosts.sh
# Author: K-Rezwan-D1-SBD
#
# Created on Sep 30, 2016, 4:14:13 PM
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX  $COLOR_INFO" "disable NetworkManager.service ....."

sudo systemctl disable NetworkManager.service 2> $TMP_ERR_OUT
sudo systemctl restart network.service 2>> $TMP_ERR_OUT

echo -e "$COLOR_SUCCESS"
sudo ip address show | grep -i inet | grep -v inet6
echo -e "$COLOR_CLEAR"


tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "disable NetworkManager.service ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "disable NetworkManager.service ..... DONE with Errors."
fi
