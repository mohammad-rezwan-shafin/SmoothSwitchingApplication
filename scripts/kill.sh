#!/usr/bin/sh
kill -9 `ps -ef | grep -i smooth-switching-application | grep -i jar | awk '{ printf $2; }'`
