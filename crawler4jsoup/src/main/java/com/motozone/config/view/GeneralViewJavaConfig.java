package com.motozone.config.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Configuration
public class GeneralViewJavaConfig {
	@Bean
	public View userCenterPage() {
		InternalResourceView irv = new InternalResourceView();
		irv.setUrl("/WEB-INF/pages/userCenter.jsp");
		return irv;
	}
}
