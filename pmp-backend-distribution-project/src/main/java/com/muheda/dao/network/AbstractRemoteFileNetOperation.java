package com.muheda.dao.network;

import com.muheda.pojo.Host;

import java.util.List;

/**
 * @desc 远程文件操作抽象类，定义了操作远程文件的
 *
 */
public abstract class AbstractRemoteFileNetOperation {

    /**
     * @desc 文件上传
     * @param filePath 文件的路径
     */
    protected abstract boolean fileDownLoad(String filePath);


    /**
     * @desc 文件下载
     */
    public abstract void fileUpLoad(String filePath , List<Host> hosts);



}
