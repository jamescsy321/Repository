package com.motozone.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.motozone.article.controller"})
@Import({com.motozone.config.view.ArticleViewJavaConfig.class,
		 com.motozone.config.view.GeneralViewJavaConfig.class,
		 com.motozone.config.view.TestViewJavaConfig.class})
public class SpringMvcJavaConfig implements WebMvcConfigurer{
	@Autowired
	ServletContext servletContext;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
       registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
       registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/static/img/");
    }
    
	@Bean
	public ViewResolver beanNameViewResolver() {
		BeanNameViewResolver bnvr = new BeanNameViewResolver();
		bnvr.setOrder(10);
		return bnvr;
	}
	
}
