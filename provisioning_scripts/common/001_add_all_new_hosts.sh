#!/bin/sh
# 
# File:   02_add_all_new_hosts.sh
# Author: K-Rezwan-D1-SBD
#
# Created on Sep 30, 2016, 4:14:13 PM
# This is for all additional Host name entries in /etc/hosts
source /vagrant/provisioning_scripts/00_const_init.sh

####
# For new addition please just give entry(s) the array element(s).
####
etc_hosts="/etc/hosts"

new_host_array[0]='192.168.56.150 	pgDB.ssapp.io      pgDB'
new_host_array[1]='192.168.56.160 	app.ssapp.io       ssapp'
new_host_array[2]='192.168.56.170 	artimis.ssapp.io   artimis'



i=0;
while [ $i -ne ${#new_host_array[@]} ]; do
    printlnC $COLOR_INFO "looking for ${new_host_array[$i]} in $etc_hosts"
    reponse=`cat $etc_hosts | grep -i "${new_host_array[$i]}"`
    if [ "${new_host_array[$i]}" = "$reponse" ]; then
        printlnC $COLOR_SUCCESS "Found entry."
    else
        printlnC $COLOR_WARN "Entry not found. Adding...."
        sudo -- sh -c "echo \"${new_host_array[$i]}\" >> $etc_hosts" 
        printlnC $COLOR_INFO "Done."
    fi
    i=`expr $i + 1` 
done




