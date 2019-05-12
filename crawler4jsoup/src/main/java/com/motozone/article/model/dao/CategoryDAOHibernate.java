package com.motozone.article.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.article.model.CategoryBean;

@Repository
public class CategoryDAOHibernate implements CategoryDAO {
	@Autowired
	private SessionFactory factory;
	private String SELECT_BY_CAT = "From com.motozone.article.model.CategoryBean a where a.category = :category";

	@Override
	public CategoryBean getCategory(String category) {
		return (CategoryBean) factory.getCurrentSession().createQuery(SELECT_BY_CAT)
							.setParameter("category", category).getSingleResult();
	}
}
