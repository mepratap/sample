package com.cubic.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFactory {

	private static final SpringFactory instance = new SpringFactory();

	private ApplicationContext applicationContext = null;

	private SpringFactory() {
		applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static SpringFactory getInstance() {
		return instance;
	}

	public <T> T getBean(Class<T> className) {
		return applicationContext.getBean(className);
	}

	public <T> T getBean(String beanName, Class<T> className) {
		return applicationContext.getBean(beanName, className);
	}

}
