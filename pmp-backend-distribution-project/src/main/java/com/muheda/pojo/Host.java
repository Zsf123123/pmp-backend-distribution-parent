package com.muheda.pojo;

/**
 * @desc 远程主机
 *
 */
public class Host {

    /**
     * 主机的IP地址
     */
    private  String ip;

    /**
     * 主机的端口
     */
    private  String port;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
