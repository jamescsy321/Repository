package com.motozone.general.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersBean {
 @Id
 private String uid;
 private Byte[] pwd;
 private String uname;
 private String email;
 
 



@Override
public String toString() {
	return "UsersBean [uid=" + uid + ", pwd=" + Arrays.toString(pwd) + ", uname=" + uname + ", email=" + email + "]";
}


public String getUid() {
	return uid;
}


public void setUid(String uid) {
	this.uid = uid;
}


public Byte[] getPwd() {
	return pwd;
}


public void setPwd(Byte[] pwd) {
	this.pwd = pwd;
}


public String getUname() {
	return uname;
}


public void setUname(String uname) {
	this.uname = uname;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}



}
