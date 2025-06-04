#!/bin/bash
# amfi_parser_json.sh

echo "[" > schemes.json
curl -s "https://www.amfiindia.com/spages/NAVAll.txt" |
awk -F';' 'NR>1 && NF>=5 {gsub(/"/, "\\\"", $4); gsub(/"/, "\\\"", $5); printf("{\"scheme\":\"%s\", \"nav\":\"%s\"},\n", $4, $5)}' >> schemes.json
sed -i '$ s/,$//' schemes.json
echo "]" >> schemes.json

echo "Saved Scheme Name and NAV in JSON to schemes.json"
