package com.motozone.article.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.article.model.ArticleBean;
import com.motozone.article.model.dao.ArticleDAO;
import com.motozone.article.model.dao.ArticleIdDAO;

public class ArticleDAOHibernateTest {
	ApplicationContext context;
	SessionFactory factory;
	ArticleDAO dao;
	ArticleIdDAO daoId;
	Integer pageSize = 5;
	Integer page = 2;
	
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		
		dao = (ArticleDAO) context.getBean("articleDAOHibernate");
		daoId = (ArticleIdDAO) context.getBean("articleIdDAOHibernate");
		
		
		// get session factory
		factory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void getArticles() {
		factory.getCurrentSession().beginTransaction();
		
		List<ArticleBean> list = dao.getArticles(daoId.selectById(550187),pageSize, page);
		
		factory.getCurrentSession().getTransaction().commit();
		
		for(ArticleBean bean : list) {
			System.out.println(bean.getDate());
		}
	}
	
	
	@After
	public void destroy() {
		factory.close();
		
		((ConfigurableApplicationContext) context).close();
	}
}
