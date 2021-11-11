#!/bin/zsh

LOG_FILE="logs.txt"

rm -f $LOG_FILE

while true
do
  line=$(top -l 1 -s 0 | grep Phys)
  vals=$(echo "$line" | tr '\n' ' ' | sed -e 's/[^0-9]/ /g' -e 's/^ *//g' -e 's/ *$//g' | tr -s ' ' | sed 's/ /\n/g')
  read -ra arr <<< "$vals"
  timestamp=$(date +"%T")
  echo "$(date +"%T");${arr[0]}M" >> $LOG_FILE
  sleep 600
done