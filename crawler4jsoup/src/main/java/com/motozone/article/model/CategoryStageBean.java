package com.motozone.article.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="category_stage")
public class CategoryStageBean {
	private Integer no;
	private CategoryBean category;
	private CategoryBean subCategory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat")
	public CategoryBean getCategory() {
		return category;
	}
	public void setCategory(CategoryBean category) {
		this.category = category;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sub_cat")
	public CategoryBean getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(CategoryBean subCategory) {
		this.subCategory = subCategory;
	}
	
	
	
}
