package com.motozone.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motozone.general.model.UsersBean;
import com.motozone.general.model.dao.UsersDAO;

@RestController
public class LoginController {
    @Autowired
	private UsersDAO usersDao;
    
    @RequestMapping(path= {"/users/{id}"},
    		method= RequestMethod.GET,
    		produces= {"application/json"})
    public UsersBean method1(@PathVariable(value="id") String uid) {
    	System.out.println("method="+uid);
    	return usersDao.select(uid);
    }
    
//    @PostMapping(path= {"/users"},
//    		consumes= {"application/json"})
//    
//    public UsersBean select(@RequestBody String id) {
//    	UsersBean result = usersDao.select(id);
//    	System.out.println("result="+result);
//    	return result;
//    }
}
