package com.muheda.utils;

import org.apache.hadoop.conf.Configuration;

/**
 * @desc HDFS 连接对象管理
 *
 */
public class HDFSConfiguation {

    public static Configuration getInstance(){
        return ConfigurationHolder.conf;
    }

    private static class ConfigurationHolder {

        private static final Configuration conf = new Configuration();

        static {
            conf.set(Contans.DFS_NAMENODE_RPC_ADDRESS_HDFSCLUSTER_NN1, ReadProperty.getConfigData(Contans.DFS_NAMENODE_RPC_ADDRESS_HDFSCLUSTER_NN1));
            conf.set(Contans.DFS_NAMENODE_RPC_ADDRESS_HDFSCLUSTER_NN2, ReadProperty.getConfigData(Contans.DFS_NAMENODE_RPC_ADDRESS_HDFSCLUSTER_NN2));
            conf.set(Contans.FS_HDFS_IMPL, Contans.ORG_APACHE_HADOOP_HDFS_DISTRIBUTEDFILESYSTEM);
        }


    }

}
