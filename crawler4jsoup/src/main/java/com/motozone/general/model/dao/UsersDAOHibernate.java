package com.motozone.general.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motozone.general.model.UsersBean;
@Repository
public class UsersDAOHibernate implements UsersDAO {
	
    @Autowired
	private SessionFactory sessionFactory;
    private static String INSERT ="INSERT INTO com.motozone.general.model.UsersBean user(uid,pwd,uname,email)";
    private static String SELECT = "from com.motozone.general.model.UsersBean user where user.uid=:uid";
    public Session getSession() {
    	return sessionFactory.getCurrentSession();
    }
    
    @Override
	public UsersBean select(String uid){
		UsersBean result=null;
		try {
			result = (UsersBean) sessionFactory
						.getCurrentSession()
						.createQuery(SELECT)
						.setParameter("uid", uid)
						.getSingleResult();
		} catch (NoResultException e) {

			e.printStackTrace();
			System.out.println("noresultException");
		}
		return result;
	}

	@Override
	public UsersBean insert(UsersBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
