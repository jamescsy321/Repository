package com.motozone.article.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.article.model.ArticleBean;
import com.motozone.article.model.ArticleIdBean;

@Repository
public class ArticleDAOHibernate implements ArticleDAO{
	@Autowired
	private SessionFactory factory;
	private final String SELECT_BY_ID = "From com.motozone.article.model.ArticleBean a where a.id = :id order by date asc";
	
	public ArticleDAOHibernate() {
		
	}
	
	@Override
	public boolean insert(ArticleBean bean) {
		
		try {
			factory.getCurrentSession().save(bean);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean insert(List<ArticleBean> list) {
		
		try {
			for(ArticleBean bean : list) {
				factory.getCurrentSession().save(bean);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public List<ArticleBean> getArticles(ArticleIdBean id,Integer pageSize,Integer page) {
		
		return factory.getCurrentSession().createQuery(SELECT_BY_ID)
									.setFirstResult(pageSize*(page - 1)) // offset
									.setMaxResults(pageSize) 			// next rows
									.setParameter("id", id)
									.getResultList();
		
	}
	
}
