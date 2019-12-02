package com.muheda.service;

import com.muheda.dao.network.impl.RemoteHDFSFileOperation;
import com.muheda.pojo.Host;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @desc 任务启动
 *
 */
public class TaskRun {

    @Autowired
    RemoteHDFSFileOperation remoteHDFSFileOperation;


    /**
     * @desc 任务运行
     * @param host
     * @param startCommand
     * @return
     */
    public boolean taskStart(Host host, String startCommand){

        /**
         * 运行成功 running : 2 如果失败 返回 fail 3
         * 同时将信息同步到数据库中
         */
        boolean isStartUpSuccess = remoteHDFSFileOperation.startTask(host, startCommand);

        return isStartUpSuccess;

    }

}
