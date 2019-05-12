package com.motozone.article.model.dao;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.article.model.CategoryBean;
import com.motozone.article.model.dao.CategoryDAO;

public class CategoryDAOHibernateTest {
	ApplicationContext context;
	SessionFactory factory;
	CategoryDAO dao;
	
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		
		dao = (CategoryDAO) context.getBean("categoryDAOHibernate");
		
		
		// get session factory
		factory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void getCategory() {
		factory.getCurrentSession().beginTransaction();
		
		CategoryBean bean = dao.getCategory("L");
		
		factory.getCurrentSession().getTransaction().commit();
		
		System.out.println(bean.getCategoryName());
	}
	
	
	@After
	public void destroy() {
		factory.close();
		((ConfigurableApplicationContext) context).close();
	}
}
