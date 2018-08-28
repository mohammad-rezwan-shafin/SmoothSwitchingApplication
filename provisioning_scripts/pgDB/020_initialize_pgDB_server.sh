#!/bin/sh
source /vagrant/provisioning_scripts/00_const_init.sh

printlnC "$SH_LINE_PREFIX $COLOR_INFO" "Intialize postgresql-server ....."

sudo postgresql-setup initdb  2> $TMP_ERR_OUT
sudo cp /vagrant/templates/pg_hba.conf /var/lib/pgsql/data/  2>> $TMP_ERR_OUT
sudo cp /vagrant/templates/postgresql.conf /var/lib/pgsql/data/  2>> $TMP_ERR_OUT

tmp_out=`cat $TMP_ERR_OUT`
echo -e "$COLOR_ERROR $tmp_out $COLOR_CLEAR"
sudo rm -f $TMP_ERR_OUT

if [ -z "$tmp_out" ]; then
    printlnC "$SH_LINE_PREFIX $COLOR_SUCCESS" "Intialize postgresql-server postgresql-contrib ..... DONE."
else
    printlnC "$SH_LINE_PREFIX $COLOR_WARN" "Intialize postgresql-server ..... DONE with Errors."
fi
