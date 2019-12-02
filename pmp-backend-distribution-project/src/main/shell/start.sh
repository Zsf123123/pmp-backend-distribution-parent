#!/usr/bash bash

#用于启动项目的脚本此处是前台启动，当运行的程序出现了异常的时候可以返回具体的状态码，将该状态码写入同路径的的文件中

PWD=`pwd`
status_file='status_code.txt'

code=`find $PWD -name ${status_file}`

if [[ ${code} -ne '' ]];then
    echo "当前已有程序失败状态文件"
else
   echo "开始创建程序状态失败文件"
   touch "$status_file"
fi