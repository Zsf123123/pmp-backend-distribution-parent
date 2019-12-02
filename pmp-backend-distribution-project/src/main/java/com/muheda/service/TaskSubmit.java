package com.muheda.service;

import com.muheda.dao.network.impl.RemoteHDFSFileOperation;
import com.muheda.pojo.Host;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @desc 任务提交service
 *
 */
public class TaskSubmit {

    @Autowired
    RemoteHDFSFileOperation remoteHDFSFileOperation;

    /**
     * @desc 任务提交上传
     *
     */
    public boolean submit(Host[] hosts, String projectName , String hdfsPath, String targetPath){

        /**
         * Host[] hosts,String projectName ,String hdfsPath, String targetPath
         */
        boolean isUploadSuccess = remoteHDFSFileOperation.upLoad(hosts, projectName, hdfsPath, targetPath);


        /**
         * 如果上传成功那么返回给军林 start: 1 如果失败 返回 fail:3
         * 同时将信息同步到数据库中
         */
        return isUploadSuccess;


    }

}
