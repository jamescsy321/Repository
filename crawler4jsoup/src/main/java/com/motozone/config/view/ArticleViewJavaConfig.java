package com.motozone.config.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Configuration
public class ArticleViewJavaConfig {
	
	
	@Bean
	public View articleCategoryPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/category.jsp");
		return view;
	}
	
	@Bean
	public View postListPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/article.jsp");
		return view;
	}
	
	@Bean
	public View postsPage() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/articleGet.jsp");
		return view;
	}
	
	
	// AJAX Resource
	
	@Bean
	public View ajaxCategory() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/ajax/categoryPage.jsp");
		return view;
	}
	
	@Bean
	public View ajaxPostList() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/ajax/postListPage.jsp");
		return view;
	}
	
	@Bean
	public View ajaxPosts() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/ajax/postsPage.jsp");
		return view;
	}
}
