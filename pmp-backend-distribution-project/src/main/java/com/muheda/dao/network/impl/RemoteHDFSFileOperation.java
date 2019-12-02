package com.muheda.dao.network.impl;

import ch.ethz.ssh2.Connection;
import com.muheda.pojo.Host;
import com.muheda.utils.Contans;
import com.muheda.utils.RemoteCommandUtil;
import com.muheda.utils.Scpclient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @desc 使用ssh登录需要将文件上传的目标服务器上并调用该目标服务器上的hdfs相关命令让其下载
 *       所以该过程是没有下载到本地的过程的，直接让目标服务器去下载
 *
 */
public class RemoteHDFSFileOperation {

    private static Logger logger = LoggerFactory.getLogger(RemoteHDFSFileOperation.class);


    /**
     * @desc 启动项目
     * @return  true:启动成功| false:启动失败
     */
    public boolean  startTask(Host host, String startCommand){

        Connection connection = RemoteCommandUtil.login(host.getIp(), Contans.REMOTE_USERNAME, Contans.REMOTE_PASSWORD);

        String execute = null;

        try {
            execute = RemoteCommandUtil.execute(connection, startCommand + "&&  $？");
        }catch (Exception e){
            logger.error("任务启动失败！!");
            e.printStackTrace();
        }

        if("0".equals(execute)){
            return true;
        }

        return false;
    }



    /**
     * @desc  上传到目标服务器上
     * @param hosts 目标服务器集合
     * @param hdfsPath hdfs上的路径
     * @param targetPath 下载到目标服务器的路径
     */
    public boolean upLoad(Host[] hosts,String projectName ,String hdfsPath, String targetPath){

        /**
         * 将下载脚本放置目标服务器上
         */
        for (int i = 0; i < hosts.length; i++) {

            try {
                FileUpLoadScp(targetPath);

                /**
                 * 在指定的服务器上开始运行
                 */
                Connection connection = RemoteCommandUtil.login(hosts[i].getIp(), Contans.REMOTE_USERNAME, Contans.REMOTE_PASSWORD);

                /**
                 * 先上脚本拥有运行权限，在启动下载
                 */
                String execute = RemoteCommandUtil.execute(connection, "chmod u+x " + targetPath + projectName  + " && /bin/bash " + targetPath + projectName);

            } catch (IOException e) {
                logger.error(hosts[i].getIp() + "hdfs 下载脚本出现问题");
                e.printStackTrace();
                return false;
            }
        }

        return true;

    }


    /**
     * @desc  将从HDFS上下载文件的脚本上传到目标服务器上
     * @param remotePath
     * @throws IOException
     */
    public void FileUpLoadScp(String remotePath) throws IOException {

        Scpclient scp = Scpclient.getInstance(Contans.REMOTE_USERNAME, Contans.SSH_PORT, Contans.REMOTE_USERNAME, Contans.REMOTE_PASSWORD);

        scp.putFile("/Users/zhangshaofan/project/pmp-backend-distribution-parent/pmp-backend-distribution-project/src/main/resources/hdfsDownload.sh","hdfsDownload.sh",remotePath,null);

    }


}
