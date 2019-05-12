package com.motozone.article.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.article.model.CategoryBean;
import com.motozone.article.model.CategoryTranslateBean;

@Repository
public class CategoryTranslateDAOHibernate implements CategoryTranslateDAO {
	
	@Autowired
	private SessionFactory factory;
	private String SELECT_BY_CAT_SRC = "From com.motozone.article.model.CategoryTranslateBean a where a.categoryName = :categoryName and a.source = :source";
	
	
	@Override
	public CategoryTranslateBean getCategoryCode(String categoryName, String source) {
		
		return (CategoryTranslateBean)factory.getCurrentSession()
				.createQuery(SELECT_BY_CAT_SRC)
				.setParameter("categoryName", categoryName)
				.setParameter("source", source).getSingleResult();
	}
	
	
}
