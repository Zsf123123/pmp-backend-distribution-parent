package com.muheda.monitor;

import com.muheda.utils.ThreadPoolUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * springboot启动类和服务器关闭类
 * 在项目一开始启动的时候就会加载
 *
 */
@Component
@Order(value = 1)
public class InitLoadDataRunner implements CommandLineRunner, DisposableBean {

	private static final Logger logger = LoggerFactory.getLogger(InitLoadDataRunner.class);

	@Autowired
	private CacheQueueConsumer cacheQueueConsumer;

	@Autowired
	private ThreadPoolProperties threadPoolProperties;

	@Override
	public void run(String... args) throws Exception {


		logger.info("开始启动缓存队列的消费者");
		ExecutorService ownThreadPool = ThreadPoolUtils.getOwnThreadPool(threadPoolProperties.getCoreCount(), threadPoolProperties.getMaxCount(), "DATA-HANDLE");

		for (int i = 0; i < threadPoolProperties.getRealCount(); i++) {
			ownThreadPool.execute(cacheQueueConsumer);
		}
	}

	@Override
	public void destroy() throws Exception {
		logger.info("System closure : { close netty server and client... } ");
	}

}
