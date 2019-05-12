package com.motozone.article.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="article_id")
public class ArticleIdBean {
	
	
	private Integer 		id;
	private String 			title;
	private CategoryBean	category;
	private String			url;
	private Integer			views = 0; // views default is 0
	
	
	public ArticleIdBean() {
	}
	
	public ArticleIdBean(Integer id,String title,CategoryBean category ,String url) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.url = url;
	}
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat")
	public CategoryBean getCategory() {
		return category;
	}
	public void setCategory(CategoryBean category) {
		this.category = category;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	
	
}
