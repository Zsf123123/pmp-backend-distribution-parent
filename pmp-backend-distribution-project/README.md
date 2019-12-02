####项目分发模块
   ##### 1: 程序分发模块(pmp-backend-distribution-project)
       1.1 资源下载
       1.2 资源校验
       1.3 资源上传到指定的服务器上
       
   ##### 2: HDFS上操作
       2.1 文件上传 hadoop dfs -put storage-hbase-device-jar-with-dependencies.jar  /home/   
       
   #### 3: HDFS java Api读取文件
        3.1在读取HDFS文件时,需要将HDFS的hdfs-site.xml和core-site.xml放置在resources路径下，此时在new Configuation()对象的时候会自己去找该配置文件并加载
           到本地缓存