package com.yghsh.wx.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 容器启动，关闭监听
 * 需要web.xml中配置此监听
 * */
public class MyServletContextListener implements ServletContextListener{

	private final static 
		org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(MyServletContextListener.class);
	
	/**
	 * 容器关闭时被调用
	 * */
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("容器关闭.......");
		
	}

	/**容器服务器启动时被调用
	 * */
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("容器启动.......");
	}
}
