#!/usr/bin/sh
curl -s  http://192.168.56.160:9090/management/health  | python -m json.tool
