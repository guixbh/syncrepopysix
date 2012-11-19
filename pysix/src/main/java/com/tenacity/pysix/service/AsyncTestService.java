package com.tenacity.pysix.service;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tenacity.pysix.asterisk.connection.AsteriskConnectionBean;

@Component
public class AsyncTestService implements
		ApplicationListener<ContextRefreshedEvent> {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("ContextStartedEvent Received");
	}

	//test task
	public void asyncTask() {
		try {
			Thread.sleep(10000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Complete execution of async. task");
	}

	@Scheduled(fixedDelay = 10000)
	public void updateCarAgeJob() {
		logger.info("Start execution of async. task");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("asterisk-connection.xml");
		ctx.refresh();
		AsteriskConnectionBean asteriskConnectionBean = ctx.getBean("asteriskConnectionBean",AsteriskConnectionBean.class);
		logger.debug("starting ");
		logger.info("pooling"+asteriskConnectionBean.getAsteriskAddress()+":"+asteriskConnectionBean.getManagerPort());
		logger.debug("stoping");
	}

}
