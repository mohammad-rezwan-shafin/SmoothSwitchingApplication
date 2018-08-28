#!/bin/sh
# 
# File:   02_add_all_new_hosts.sh
# Author: K-Rezwan-D1-SBD
#
# Created on Sep 30, 2016, 4:14:13 PM
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX  $COLOR_INFO" "Fixing Timezone and NTP ....."

printlnC "$SH_LINE_PREFIX  $COLOR_INFO" "backing up /etc/localtime"
if [ -z "/etc/localtime.bak" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Already exists /etc/localtime, not need to backup"
else
	sudo mv -v /etc/localtime /etc/localtime.bak 2> $TMP_ERR_OUT
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "backing up /etc/localtime .....DONE."
fi


printlnC "$SH_LINE_PREFIX  $COLOR_INFO" "Setting Time Zone to Asia/Dhaka"
sudo ln -s /usr/share/zoneinfo/Asia/Dhaka /etc/localtime 2>> $TMP_ERR_OUT

printlnC "$SH_LINE_PREFIX  $COLOR_INFO" "Fixing NTP Server"
sudo yum install ntp ntpdate -y 2>> $TMP_ERR_OUT

#ntp_conf="/etc/ntp.conf"
#
#
#if [ -z "$ntp_conf.bak" ]; then
#    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Already exists /etc/ntp.conf.bak, not need to backup"
#else
#	sudo mv -v /etc/ntp.conf /etc/ntp.conf.bak 2> $TMP_ERR_OUT
#    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "backing up /etc/ntp.conf .....DONE."
#fi
#
#
#sudo bash -c "echo 'server nexus.ksl.com' > /etc/ntp.conf"


sudo /bin/systemctl restart  ntpd.service 2>> $TMP_ERR_OUT


echo -e "$COLOR_SUCCESS"
sudo ntpq -p
echo -e "$COLOR_CLEAR"





tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Fixing Timezone and NTP .....DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Fixing Timezone and NTP .....DONE with Errors."
fi
