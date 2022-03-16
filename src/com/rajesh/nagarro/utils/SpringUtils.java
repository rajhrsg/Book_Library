package com.rajesh.nagarro.utils;

import java.io.File;

import org.apache.log4j.Logger;
import com.rajesh.nagarro.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Utility class to create object of UserDao
 */
public class SpringUtils {

	private static Logger logger = Logger.getLogger(SpringUtils.class);

	public static UserDao getUserDao() {
		@SuppressWarnings("deprecation")
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(
				System.getProperty("rootPath") + File.separator + "WEB-INF"
						+ File.separator + "spring-application.xml"));
		UserDao userDao = (UserDao) beanFactory.getBean("userDao");

		logger.info("userDao " + userDao);
		return userDao;
	}
}
