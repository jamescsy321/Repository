package com.motozone.article.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.article.model.CategoryStageBean;
import com.motozone.article.model.dao.CategoryDAO;
import com.motozone.article.model.dao.CategoryStageDAO;

public class CategoryStageDAOHibernateTest {
	ApplicationContext context;
	SessionFactory factory;
	CategoryDAO	dao;
	CategoryStageDAO stageDao;
	
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		
		dao = (CategoryDAO) context.getBean("categoryDAOHibernate");
		stageDao = (CategoryStageDAO) context.getBean("categoryStageDAOHibernate");
		
		
		// get session factory
		factory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void getSubcategory() {
		factory.getCurrentSession().beginTransaction();
		
		List<CategoryStageBean> list = stageDao.getSubcategory(dao.getCategory("LAN"));
		
		
		factory.getCurrentSession().getTransaction().commit();
		
		for(CategoryStageBean bean : list) {
			System.out.println(bean.getSubCategory().getCategory() + " : " + bean.getSubCategory().getCategoryName());
		}
		
	}
	
	
	@After
	public void destroy() {
		factory.close();
		((ConfigurableApplicationContext) context).close();
	}
}
