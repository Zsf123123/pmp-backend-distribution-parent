package com.muheda.test;

import org.junit.Test;

public class StringUtils {

    @Test
    public void transferString(){

        String str = "local.Cache.File.Path";
        String str2 = "org.apache.hadoop.hdfs.DistributedFileSystem";

        System.out.println(str.replace(".","_").toUpperCase());
        System.out.println(str2.replace(".","_").toUpperCase());

    }


}
