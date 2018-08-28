#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Copying artifacts ....."

cp -v /vagrant/build/libs/smooth-switching-application-*.jar  /home/vagrant/  2> $TMP_ERR_OUT
chown vagrant:vagrant /home/vagrant/smooth-switching-application-*.jar  2>> $TMP_ERR_OUT

cp -v /vagrant/scripts/*.sh  /home/vagrant/  2>> $TMP_ERR_OUT
chown vagrant:vagrant /home/vagrant/*.sh  2>> $TMP_ERR_OUT
dos2unix /home/vagrant/*.sh  2>> $TMP_ERR_OUT
chmod +x /home/vagrant/*.sh  2>> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Copying artifacts ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Copying artifacts ..... DONE with Errors."
fi
