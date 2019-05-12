package com.motozone.article.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.article.model.CategoryBean;
import com.motozone.article.model.CategoryStageBean;

@Repository
public class CategoryStageDAOHibernate implements CategoryStageDAO {
	@Autowired
	private SessionFactory factory;
	private String SELECT_BY_CAT = "From com.motozone.article.model.CategoryStageBean a where a.category = :category";
	
	@Override
	public List<CategoryStageBean> getSubcategory(CategoryBean category) {
		
		return factory.getCurrentSession().createQuery(SELECT_BY_CAT)
				.setParameter("category", category).getResultList();
	}
	
}
