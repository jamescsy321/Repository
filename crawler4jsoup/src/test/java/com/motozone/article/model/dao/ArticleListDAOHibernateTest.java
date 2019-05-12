package com.motozone.article.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.article.model.ArticleListBean;
import com.motozone.article.model.dao.ArticleListDAO;

public class ArticleListDAOHibernateTest {
	ApplicationContext context;
	SessionFactory factory;
	ArticleListDAO dao;
	Integer pageSize = 20;
	Integer page = 2;
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		
		dao = (ArticleListDAO) context.getBean("articleListDAOHibernate");
		
		
		// get session factory
		factory = (SessionFactory) context.getBean("sessionFactory");
	}
	
	@Test
	public void getArticleList() {
		factory.getCurrentSession().beginTransaction();
		
		List<ArticleListBean> list = dao.getArticleList("LAN",pageSize, page);
		
		factory.getCurrentSession().getTransaction().commit();
		
		for(ArticleListBean bean : list) {
			System.out.println(bean.getTitle());
		}
	}
	
	
	@After
	public void destroy() {
		factory.close();
		((ConfigurableApplicationContext) context).close();
	}
}
