#!/usr/bin/sh
curl -X POST -s http://localhost:9090/management/shutdown | python -m json.tool
