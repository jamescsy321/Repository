package com.motozone.article.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="article")
public class ArticleBean {
	
	private Integer			no;
	private ArticleIdBean	id;
	private Integer 		userNo = 0; // 0 present GM account
	private String 			author;
	private Timestamp 		date;
	private String 			content;
	private String 			imgSrc = null; // default is no image
	
	public ArticleBean() {
		
	}
	
	public ArticleBean(ArticleIdBean id, String author, Timestamp date, String content, String imgSrc) {
		this.id = id;
		this.author = author;
		this.date = date;
		this.content = content;
		this.imgSrc = imgSrc;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	public ArticleIdBean getId() {
		return id;
	}

	public void setId(ArticleIdBean id) {
		this.id = id;
	}

	@Column(name="uNo")
	public Integer getUserNo() {
		return userNo;
	}
	
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public void setDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			this.date = new Timestamp(sdf.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="img")
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
}
