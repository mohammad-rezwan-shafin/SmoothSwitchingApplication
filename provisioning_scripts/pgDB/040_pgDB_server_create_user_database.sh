#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "postgresql-server Creating User and Database ....."

sudo -u postgres psql -c "CREATE USER ssapp WITH PASSWORD 'ssapp123';" 2> $TMP_ERR_OUT
sudo -u postgres psql -c "CREATE DATABASE ssapp;" 2>> $TMP_ERR_OUT
sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE ssapp to ssapp;" 2>> $TMP_ERR_OUT
sudo -u postgres psql -c "CREATE SCHEMA ssapp AUTHORIZATION ssapp;" ssapp 2>> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "postgresql-server Creating User and Database  ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "postgresql-server Creating User and Database  ..... DONE with Errors."
fi
