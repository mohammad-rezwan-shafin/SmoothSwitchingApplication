#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Manage postgresql-server Service ....."

sudo systemctl start postgresql  
#2> $TMP_ERR_OUT
sudo systemctl enable postgresql 
#2>> $TMP_ERR_OUT

echo -e "$COLOR_SUCCESS"
sudo systemctl status postgresql 
echo -e "$COLOR_CLEAR"



# tmp_out=`cat $TMP_ERR_OUT`
# echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
# sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Manage postgresql-server Service  ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Manage postgresql-server Service  ..... DONE with Errors."
fi
