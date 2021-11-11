#!/bin/zsh

ARG=$1

case $ARG in
  "START")
    rm -rf "temp/"
    mkdir "temp/"
    echo $! > "temp/stored_pid.txt"
    # cat $daemon >> daemon.sh
    chmod ugo+rwx daemon.sh
    ./daemon.sh &
  ;;
  "STATUS")
    if [ -f "temp/stored_pid.txt" ]; then
      if ps -p "$(cat temp/stored_pid.txt)" > /dev/null 2>&1
        then
          echo "Daemon running..."
        else
          echo "Daemon stopped."
      fi
    else
      echo "Daemon stopped."
    fi
  ;;
  "STOP")
    mem_process_pid=$(cat temp/stored_pid.txt)
    kill -9 "$(cat temp/stored_pid.txt)"
    rm -rf "temp/"
  ;;
esac