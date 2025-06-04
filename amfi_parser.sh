#!/bin/bash
# amfi_parser.sh

curl -s "https://www.amfiindia.com/spages/NAVAll.txt" |
awk -F';' 'BEGIN{OFS="\t"} NR>1 && NF>=5 {print $4, $5}' > schemes.tsv

echo "Saved Scheme Name and NAV to schemes.tsv"
