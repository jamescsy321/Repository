package com.motozone.article.model.dao;

import com.motozone.article.model.CategoryTranslateBean;

public interface CategoryTranslateDAO {
	public CategoryTranslateBean getCategoryCode(String categoryName,String source);
}
