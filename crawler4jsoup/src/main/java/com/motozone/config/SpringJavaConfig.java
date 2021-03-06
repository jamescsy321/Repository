package com.motozone.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.motozone.article","com.motozone.general"})
@EnableTransactionManagement
public class SpringJavaConfig {
	
	
	// standard dataSource
//	@Bean
//	public DataSource dataSource() {
//		DataSource ds = null;
//		
//		try {
//			InitialContext context = new InitialContext();
//			ds = (DataSource) context.lookup("java:comp/env/jdbc/TestDB");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		
//		return ds;
//		
//	}
	
	// spring fake dataSource for normal java program
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		
		// set properties
		dmds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dmds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=DB01");
		dmds.setUsername("sa");
		dmds.setPassword("passw0rd");
		
		return dmds;
		
	}
	//for web program
//	@Bean
//	public DataSource dataSource() {
//		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
//		factory.setJndiName("java:comp/env/jdbc/TestDB");
//		factory.setProxyInterface(DataSource.class);
//		
//		try {
//			
//			// look up
//			factory.afterPropertiesSet();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return (DataSource) factory.getObject();
//		
//	}
	
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(dataSource())
				.configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	@Bean
	public PlatformTransactionManager transactionManagement() {
		return new HibernateTransactionManager(sessionFactory());
		
	}

}
