package com.motozone.article.model.service;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.article.model.service.ArticleService;

public class ArticleServiceTest {
	ApplicationContext context;
	SessionFactory factory;
	ArticleService service;
	Integer pageSize = 5;
	Integer page = 2;
	
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		
		service = (ArticleService) context.getBean("articleService");
		
		// get session factory
		factory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void getId() {
		
		factory.getCurrentSession().beginTransaction();
		
		System.out.println(service.getId("Hello", "LAN", "wwww").getId());
		
		factory.getCurrentSession().getTransaction().commit();
	}
	
	@After
	public void destroy() {
		factory.close();
		
		((ConfigurableApplicationContext) context).close();
	}
}
