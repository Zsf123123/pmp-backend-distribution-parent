package com.muheda.test;

import com.muheda.service.impl.HDFSFileOperation;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @desc hdfs相关操作
 */
public class HDFSFileOperationTest {

    public static Logger logger = LoggerFactory.getLogger(HDFSFileOperationTest.class);


    @Test
    public void testFile() throws IOException {

       new HDFSFileOperation().fileDownLoad("/storage-hbase-device-jar-with-dependencies.jar");

    }

    /**
     * @desc 从HDFS文件系统上下载一个文件
     */
    @Test
    public void HDFSUpDownLoad() {

            Configuration conf = new Configuration();

            /**
             * 读取HDFS时设置高可用读取，否则可能会出现namenode的主备切换的问题
             */
            FileSystem fs = null;

            try {
                fs = FileSystem.get(conf);
            } catch (IOException e) {
                logger.error("HDFS 文件获取异常,请检查HDFS相关配置");
                e.printStackTrace();
            }


           /**
             * 读取HDFS上面的文件名（是全路径名）
             */
            Path file = new Path("/storage-hbase-device-jar-with-dependencies.jar");


            /**
             * 构建文件读取输入流
             */
            FSDataInputStream fi = null;

            try {
                fi = fs.open(file);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("请检查HDFS文件全路径名是否正确!!");
            }

            File outFile = new File("/opt/soft/storage-hbase-device-jar-with-dependencies.jar");

            if(outFile.exists()) {
                logger.warn("上传文件已存在,新将其覆盖!!");
                boolean delete = outFile.delete();

                try {
                    if (!outFile.createNewFile()) {
                        logger.error("文件创建失败");
                        return;
                    }
                } catch (IOException e) {
                    logger.error("文件创建失败");
                    e.printStackTrace();
                }

            }

            byte[] bytes = new byte[1024 * 10];
            int len = -1;

            BufferedOutputStream bo = null;

            try {
                bo = new BufferedOutputStream(new FileOutputStream(outFile));

                while ((len = fi.read(bytes)) != -1) {
                    bo.write(bytes,0,len);
                }

            }catch (Exception ex){
                ex.printStackTrace();
                logger.error("输出流创建失败！！");

            }finally {

                if(bo != null){
                    try {
                        bo.close();
                    } catch (IOException e) {
                        logger.error("BufferedOutputStream 关闭失败");
                        e.printStackTrace();
                    }
                }

                if(fi != null){
                    try {
                        fi.close();
                    } catch (IOException e) {
                        logger.error("FileInput 关闭失败");
                        e.printStackTrace();
                    }
                }

                if(fs != null){
                    try {
                        fs.close();
                    } catch (IOException e) {
                        logger.error("FileSystem 关闭失败");
                        e.printStackTrace();
                    }
                }




            }


    }



    public void downLoad() throws MalformedURLException {

        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("windine.blogdriver.com/logo.gif");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream
                    ();
            FileOutputStream fs = new FileOutputStream("/opt/soft/");

            byte[] buffer = new byte[1204];
            int length;

            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void test(File src,File desc) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));

        int len = 0;
        byte[] b = new byte[1024*10];

        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }

        bos.close();
        bis.close();
    }

}
