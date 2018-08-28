#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

rc_file="/etc/rc.local"

target_file="$rc_file"
search_text="chef-server-ctl"
append_line="chef-server-ctl start"
test_content_and_append_to_file  $target_file  "$search_text"  "$append_line"

target_file="$rc_file"
search_text="chef-manage-ctl"
append_line="chef-manage-ctl start"
test_content_and_append_to_file  $target_file  "$search_text"  "$append_line"
