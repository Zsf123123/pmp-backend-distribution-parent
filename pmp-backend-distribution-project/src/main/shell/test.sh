#! /bin/bash

PWD=`pwd`
status_file='status_code.txt'

code=`find $PWD -name ${status_file} |wc -l`

if  [ 0 != "$code" ];then
    echo "当前已有程序失败状态文件"
else
   echo "开始创建程序状态失败文件"
   touch "$status_file"
fi

echo "启动命令: $1"

 `$1`

echo $! >  "$PWD/$status_file"
