package com.muheda.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import com.muheda.utils.RemoteCommandUtil;
import org.junit.Test;
import java.io.IOException;


public class LinuxFileSystemOperationTest {


    /**
     *
     * @throws Exception
     */
    @Test
    public void testFileUploadFTP() throws Exception {
        Ftp ftp = new Ftp("master-1.data.com", 20, "root", "www.muheda.com");
        ftp.upload("/opt/soft/","storage-hbase-device-jar-with-dependencies.jar");
    }


    @Test
    public void testFileUpLoadScp(){
        Scpclient scp = Scpclient.getInstance("172.17.3.143", 22, "root", "www.muheda.com");
//      scp.putFile("/opt/soft/storage-hbase-device-jar-with-dependencies.jar", "storage-hbase-device-jar-with-dependencies.jar", "/opt/soft/", null);

//        scp.putFile("/Users/zhangshaofan/project/pmp-backend-parent/pmp-backend-distribution-project/src/main/shell/test.sh","test.sh","/opt",null);



        scp.putFile("/Users/zhangshaofan/project/pmp-backend-distribution-parent/pmp-backend-distribution-project/src/main/resources/hdfsDownload.sh","hdfsDownload.sh","/opt/test",null);


    }

    /**
     * @desc 调用远程linux shell客户端并封装命令
     *
     */
    @Test
    public void testRemoteShellHDFSClient(){

        Connection connection = RemoteCommandUtil.login("172.17.3.143", "root", "www.muheda.com");

        String execute = RemoteCommandUtil.execute(connection, "hdfs  dfs  -get /car-alarm-analysis-jar-with-dependencies.jar   /opt/soft");

/*      String execute = RemoteCommandUtil.execute(connection, "nohup spark-submit --master yarn --deploy-mode client --driver-memory 1G --num-executors 2 --executor-memory 1G --executor-cores 2 --class com.muheda.Kafka2HbaseApp   /opt/spark/jar/gtInfo.jar  >  /opt/spark/log/gtInfo.log  2>&1 &" );*/


//        String execute = RemoteCommandUtil.execute(connection, "if [ ! -d  " + + " ]; then\n  mkdir  -p /opt/test4\n fi");




        System.out.println(execute);

/*        Connection connection1 = RemoteCommandUtil.login("172.17.3.143", "root", "www.muheda.com");

        String execute1 = RemoteCommandUtil.execute(connection1, "ps -ef|grep gtInfo.jar | grep -v grep| wc -l");

        System.out.println(execute1);*/

        connection.close();

    }


    /**
     *@desc 调用远程shell客户端发送命令，并获取返回的结果查看该命令是否执行成功
     *
     */
    @Test
    public void  testRemoteClient() throws IOException {

        RemoteCommandUtil remoteCommandUtil = new RemoteCommandUtil();

        Connection connection = RemoteCommandUtil.login("172.17.3.143", "root", "www.muheda.com");

        Session session = connection.openSession();

//        session.execCommand("ps -ef|grep gtInfo.jar | grep -v grep| wc -l");

        session.execCommand("chmod u+x /opt/test.sh");


        /*String s = RemoteCommandUtil.processStdout(session.getStdout(), RemoteCommandUtil.DEFAULTCHART);
        System.out.println(s);

        String s1 = RemoteCommandUtil.processStdout(session.getStderr(), RemoteCommandUtil.DEFAULTCHART);
        System.out.println(s1);
*/


        session.close();
        connection.close();


    }

}
