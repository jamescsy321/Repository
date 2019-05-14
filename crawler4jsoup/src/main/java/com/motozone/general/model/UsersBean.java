package com.motozone.general.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UsersBean {
 
 private Integer no;
 private String id;
 private Byte[] pwd;
 private String name;
 private String email;
 private String pic;
 


@Override
public String toString() {
	return "UsersBean [no=" + no + ", id=" + id + ", pwd=" + Arrays.toString(pwd) + ", name=" + name + ", email="
			+ email + ", pic=" + pic + "]";
}
@Id
@Column(name="uNo")
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Integer getNo() {
	return no;
}
public void setNo(Integer no) {
	this.no = no;
}
@Column(name="uID")
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
@Column(name="pwd")
public Byte[] getPwd() {
	return pwd;
}
public void setPwd(Byte[] pwd) {
	this.pwd = pwd;
}
@Column(name="uName")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name="email")
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(name="pic")
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
} 
 

}
