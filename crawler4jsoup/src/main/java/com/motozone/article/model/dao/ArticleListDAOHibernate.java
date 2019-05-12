package com.motozone.article.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.article.model.ArticleListBean;

@Repository
public class ArticleListDAOHibernate implements ArticleListDAO {
	
	@Autowired
	private SessionFactory factory;
	private final String SELECT_BY_CAT = "From com.motozone.article.model.ArticleListBean a where a.category = :category order by date ";
	
	@Override
	public List<ArticleListBean> getArticleList(String category,Integer pageSize,Integer page) {
		return factory.getCurrentSession().createQuery(SELECT_BY_CAT + "desc")
										.setParameter("category", category)
										.setFirstResult(pageSize*(page - 1))
										.setMaxResults(pageSize)
										.getResultList();
	}
	
	@Override
	public List<ArticleListBean> getArticleList(String category,Integer pageSize,Integer page,String order) {
		return factory.getCurrentSession().createQuery(SELECT_BY_CAT + order)
										.setParameter("category", category)
										.setFirstResult(pageSize*(page - 1))
										.setMaxResults(pageSize)
										.getResultList();
	}


}
