package com.muheda.dao.network.impl;

import com.muheda.pojo.Host;
import com.muheda.dao.network.AbstractRemoteFileNetOperation;

import java.util.List;

/**
 * @desc 操作文件系统的上传和瞎子
 * @author zhangshaofan
 *
 */
public class LinuxFileSystemNetOperation extends AbstractRemoteFileNetOperation {

    @Override
    protected boolean fileDownLoad(String filePath) {
        return false;
    }

    @Override
    public void fileUpLoad(String filePath, List<Host> hosts) {






    }
}
