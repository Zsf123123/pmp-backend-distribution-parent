package com.muheda.monitor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Description
 **/
@Component
@ConfigurationProperties(prefix = "thread.handle")
public class ThreadPoolProperties {

    private int realCount;

    private int maxCount;

    private int coreCount;

    public int getRealCount() {
        return realCount;
    }

    public void setRealCount(int realCount) {
        this.realCount = realCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }
}
