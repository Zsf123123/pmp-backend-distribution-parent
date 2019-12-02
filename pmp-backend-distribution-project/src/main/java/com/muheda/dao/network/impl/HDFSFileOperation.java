package com.muheda.dao.network.impl;

import com.muheda.pojo.Host;
import com.muheda.dao.network.AbstractRemoteFileNetOperation;
import com.muheda.utils.Contans;
import com.muheda.utils.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @desc 操作HDFS上面的文件
 * @author zhangshaofan
 * @date  2019/11/25
 *
 */
public class HDFSFileOperation extends AbstractRemoteFileNetOperation {

    private  static Logger logger = LoggerFactory.getLogger(HDFSFileOperation.class);

    private static final Configuration conf = new Configuration();

    /**
     * @param filePath  HDFS文件的全路径名.例如:(/opt/data/1.txt)
     */
    @Override
    public boolean fileDownLoad(String filePath) {

        /**
         * 获取HDFSConfiguation 对象
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
        Path file = new Path(filePath);

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

        String packageName = StringUtils.getProjectNameByFullPathName(filePath, Contans.regex);

        if(packageName == null){
            return false;
        }

        File outFile = new File(Contans.LOCAL_CACHE_FILE_PATH + packageName );

        if(outFile.exists()) {
            logger.warn("上传文件已存在,新将其覆盖!!");
            boolean delete = outFile.delete();

            try {
                if (!delete || !outFile.createNewFile()) {
                    logger.error("文件创建失败或者文件删除失败");
                    return false;
                }
            } catch (IOException e) {
                logger.error("文件创建失败");
                e.printStackTrace();
            }
        }

        byte[] bytes = new byte[Contans.CACHE_SIZE];
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
            closeFileStream(fs, fi, bo);
        }

        return  true;
    }


    @Override
    public void fileUpLoad(String filePath, List<Host> hosts) {

    }


    /**
     * @desc 关闭文件流
     * @param fs
     * @param fi
     * @param bo
     */
    private void closeFileStream(FileSystem fs, FSDataInputStream fi, BufferedOutputStream bo) {
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
