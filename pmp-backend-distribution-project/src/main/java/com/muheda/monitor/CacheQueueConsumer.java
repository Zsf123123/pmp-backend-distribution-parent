package com.muheda.monitor;


import com.muheda.pojo.Task;
import com.muheda.service.MonitorTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @desc 将之前已经完成一部分指标的数据从队列中进行消费。进行外部接口的调用
 *
 */
@Component("CacheQueueConsumer")
public class CacheQueueConsumer implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(CacheQueueConsumer.class);

    ArrayBlockingQueue queue = MonitorTask.queue;


    @Override
    public void run() {

        for(;;){

            try {
                Task take = (Task)queue.take();

                if(take == null) {
                    continue;
                }

                realTimeMonitor(take);
            } catch (InterruptedException e) {
                logger.error("task 任务取出出现问题 ！！");
                e.printStackTrace();
            }

        }

    }

    /**
     *
     * @desc 查看当前该运行的任务现在是否处于运行状态
     * @param task
     */
    public void  realTimeMonitor(Task task){

        /**
         *
         */





    }

}




















