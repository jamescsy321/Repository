package com.motozone.general.model.dao;

import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.motozone.general.model.UsersBean;
import com.motozone.general.model.dao.UsersDAO;

public class UsersDAOHibernateTest {
	
    private static ApplicationContext context;
	
    private static SessionFactory sessionFactory;

	private static UsersDAO usersDao=null;
	@Before
	public void setUp() throws Exception {
		
		
		context = new AnnotationConfigApplicationContext(com.motozone.config.SpringJavaConfig.class);
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		System.out.println("sessionFactory="+sessionFactory);
		usersDao = (UsersDAO)context.getBean("usersDAOHibernate");
		System.out.println("usersDao="+usersDao);
		//Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
	    // System.out.println("Transaction="+transaction);
	}

	

	@Test
	public void test() {
		sessionFactory.getCurrentSession().beginTransaction();
		
		UsersBean result = usersDao.select("abc");
		System.out.println("result="+result);
		System.out.println("email="+result.getEmail());
		//將資料庫pwd與新設的password做byte陣列資料比對
		String password = "A";
		Byte[] pwd = result.getPwd();
		byte[] pwdTrans = new byte[pwd.length];
		
		for(int i=0 ; i<pwd.length ; i++) {
			pwdTrans[i] = pwd[i].byteValue();
		}
		
		boolean pwdCheck = Arrays.equals(pwdTrans, password.getBytes());
		
		System.out.println(pwdCheck);
		//String email= haha.getEmail();
		//System.out.println("email="+email);
		sessionFactory.getCurrentSession().getTransaction().commit();
		
		
		//System.out.println("email="+haha.getEmail());
		
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		sessionFactory.close();
		((ConfigurableApplicationContext) context).close();		
	}

}
