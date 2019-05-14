package com.motozone.general.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.general.model.UsersBean;
@Repository
public class UsersDAOHibernate implements UsersDAO {
	
    @Autowired
	private SessionFactory sessionFactory;
   
    private static String SELECT = "from com.motozone.general.model.UsersBean user where user.id=:uID";
    public Session getSession() {
    	return sessionFactory.getCurrentSession();
    }
    
    @Override
	public UsersBean select(String id){
		UsersBean result=null;
		try {
			result = (UsersBean) sessionFactory
						.getCurrentSession()
						.createQuery(SELECT)
						.setParameter("uID", id)
						.getSingleResult();
		} catch (NoResultException e) {

			e.printStackTrace();
			System.out.println("no resultException");
		}
		return result;
	}

	@Override
	public boolean insert(UsersBean bean) {
		try {
			sessionFactory
			.getCurrentSession()
			.save(bean);
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
}
