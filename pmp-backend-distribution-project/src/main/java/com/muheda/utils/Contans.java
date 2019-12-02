package com.muheda.utils;

/**
 * @desc   常量封装接口
 * @author zhangshaofan
 *
 */
public interface Contans {


    /**
     * 读取HDFS的NAMENODE1的地址
     */
     String  DFS_NAMENODE_RPC_ADDRESS_HDFSCLUSTER_NN1 = "dfs.namenode.rpc-address.hdfscluster.nn1";

    /**
     * 读取HDFS的NAMENODE2的地址
     */
     String  DFS_NAMENODE_RPC_ADDRESS_HDFSCLUSTER_NN2 = "dfs.namenode.rpc-address.hdfscluster.nn2";

     String FS_HDFS_IMPL = "fs.hdfs.impl";

     String ORG_APACHE_HADOOP_HDFS_DISTRIBUTEDFILESYSTEM = "org.apache.hadoop.hdfs.DistributedFileSystem";

    /**
     * 配置文件名称
     */
     String APPLICATION_PROPERTIES = "application.properties";

    /**
     * 字符串null
     */
     String NULL  = "null";

     Integer ONE = 1;

     Integer ZERO = 0;

    /**
     * 文件名分隔符
     */
     String regex = "/";

    /**
     * 上传文件本地缓存目录
     */
    String LOCAL_CACHE_FILE_PATH = "/opt/soft/";

    /**
     * 写磁盘文件缓冲区大小
     */
    Integer CACHE_SIZE = 1024 * 10;

    /**
     * 远程主机的用户名
     */
    String REMOTE_USERNAME = "root";

    /**
     * 远程主机的密码
     */
    String REMOTE_PASSWORD = "wwww.muheda.com";



}
