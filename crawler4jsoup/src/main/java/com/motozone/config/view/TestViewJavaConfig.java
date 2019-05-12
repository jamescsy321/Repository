package com.motozone.config.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Configuration
public class TestViewJavaConfig {
	@Bean
	public View index() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/test/index.jsp");
		return view;
	}
	
	@Bean
	public View list() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/test/list.jsp");
		return view;
	}
	
	@Bean
	public View article() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/test/article.jsp");
		return view;
	}
}
