#!/bin/bash

#hdfs_path=/car-alarm-analysis-jar-with-dependencies.jar
#target_path=/opt/test3
#target_file=/opt/test3/car-alarm-analysis-jar-with-dependencies.jar

hdfs_path=$1
target_path=$2
target_file=$3

if [[ ! -d "$target_path" ]]; then
    mkdir  -p ${target_path}
fi

if [[ -f  $"target_pat"  ]];then
	mv -f  ${target_file} /dev/null
	echo $?
fi

hdfs dfs -get ${hdfs_path}  /opt/test

echo $?