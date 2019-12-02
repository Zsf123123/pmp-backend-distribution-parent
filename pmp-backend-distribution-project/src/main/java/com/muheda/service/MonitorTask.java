package com.muheda.service;

import com.muheda.pojo.Task;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @desc 实时监控任务
 *       需要将已经启动的项目进行实时的监控，使用一个缓存的队列进行记录相关需要监控的任务
 *
 */

@Component
@Order(value = 1)
public class MonitorTask {


    public  static  ArrayBlockingQueue<Task>  queue  = new ArrayBlockingQueue(1000);



}
