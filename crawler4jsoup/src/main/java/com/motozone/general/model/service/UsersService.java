package com.motozone.general.model.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.motozone.general.model.UsersBean;
import com.motozone.general.model.dao.UsersDAO;

@Service
@Transactional
public class UsersService {
    @Autowired
	private UsersDAO usersDao;
	public UsersBean login(String id,String pwd) {
		UsersBean bean = usersDao.select(id);
		if(bean!=null) {
			if(pwd!=null && pwd.length()!=0) {
				Byte[] password = bean.getPwd();//資料庫抓出
				byte[] pwdTran =new byte[password.length];
				for(int i=0;i<password.length;i++) {
					pwdTran[i] =password[i].byteValue();
				}
				byte[] pwdinput = pwd.getBytes();//使用者輸入
				 
				if(Arrays.equals(pwdTran,pwdinput)){
			   return bean;
			   
			   //userbean比對完後再與usersviewbean比對
			   //可能是usersviewbean bean1 = usersviewdao.select(bean.getid)
			 }
			
		}
		
	}
		System.out.println("null");
		return null;
	}	
	

}
