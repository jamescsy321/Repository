package com.motozone.article.model.dao;

import java.util.List;

import com.motozone.article.model.CategoryBean;
import com.motozone.article.model.CategoryStageBean;

public interface CategoryStageDAO {
	public List<CategoryStageBean> getSubcategory(CategoryBean category);
}
