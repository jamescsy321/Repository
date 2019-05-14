package com.motozone.general.model.service;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.general.model.UsersBean;
import com.motozone.general.model.dao.UsersDAO;

public class UserServiceTest {
   private static ApplicationContext context;
   private static SessionFactory sessionFactory;
   private static UsersService usersService;
   
	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		usersService = (UsersService) context.getBean("usersService");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}

	@After
	public void tearDown() throws Exception {
		sessionFactory.close();
		((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void usersService() {
		sessionFactory.getCurrentSession().beginTransaction();
		UsersBean result1 = usersService.login("abc123", "12234567");
		System.out.println("result1="+result1);
		
		UsersBean result2 = usersService.login("abc", "123456");
		System.out.println("result2="+result2);
		
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

}
