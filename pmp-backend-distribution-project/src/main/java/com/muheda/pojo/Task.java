package com.muheda.pojo;


import java.util.Arrays;

/**
 * 已经在执行的任务的抽象实体
 *
 */
public class Task {


    /**
     * 运行的任务ID编号
     */
    private String taskId;

    /**
     * 需要发布到的服务器
     */
    private Host[] hosts;

    /**
     * 需要任务运行的服务器
     */
    private String host;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目所在HDFS的路径
     */
    private String hdfsPath;


    /**
     * 部署和运行的服务器的路径
     */
    private String targetPath;

    /**
     * 任务的执行状态
     */
    private String state;

    /**
     * 任务执行时间
     */
    private String taskCreateTIime;


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Host[] getHosts() {
        return hosts;
    }

    public void setHosts(Host[] hosts) {
        this.hosts = hosts;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaskCreateTIime() {
        return taskCreateTIime;
    }

    public void setTaskCreateTIime(String taskCreateTIime) {
        this.taskCreateTIime = taskCreateTIime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", hosts=" + Arrays.toString(hosts) +
                ", host='" + host + '\'' +
                ", projectName='" + projectName + '\'' +
                ", hdfsPath='" + hdfsPath + '\'' +
                ", targetPath='" + targetPath + '\'' +
                ", state='" + state + '\'' +
                ", taskCreateTIime='" + taskCreateTIime + '\'' +
                '}';
    }
}
