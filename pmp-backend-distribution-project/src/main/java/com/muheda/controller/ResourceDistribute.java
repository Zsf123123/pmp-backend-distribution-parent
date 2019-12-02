package com.muheda.controller;

import com.muheda.pojo.Host;
import com.muheda.dao.network.impl.RemoteHDFSFileOperation;
import com.muheda.pojo.Task;
import com.muheda.service.MonitorTask;
import com.muheda.service.TaskRun;
import com.muheda.service.TaskSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ResourceDistribute")
public class ResourceDistribute {

    @Autowired
    MonitorTask monitorTask;

    @Autowired
    TaskRun taskRun;

    @Autowired
    TaskSubmit taskSubmit;


    /**
     * @desc 项目提交运行，需要将项目程序从文件系统上下载，并上传到指定的服务器及相关路径
     *
     */
    @RequestMapping("/submit")
    public String submitProjectWithRun(String json){

        /**
         * 一开始接收到命令返回给军林 create : 0
         */

        String taskId = null;
        Host [] hosts  = null;
        String projectName = null;
        String hdfsPath = null;
        String targetPath = null;
        Host host = null;
        String startCommand = null;


        boolean submit = taskSubmit.submit(hosts, projectName, hdfsPath, targetPath);

        return  null;

    }


    @RequestMapping("/taskStart")
    public void startTask(String taskId){




    }



    @RequestMapping("/killTask")
    public void  killTask(String taskId){



    }





}
