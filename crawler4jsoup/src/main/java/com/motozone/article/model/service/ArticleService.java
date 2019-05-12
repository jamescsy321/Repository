package com.motozone.article.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.motozone.article.model.ArticleBean;
import com.motozone.article.model.ArticleIdBean;
import com.motozone.article.model.ArticleListBean;
import com.motozone.article.model.CategoryStageBean;
import com.motozone.article.model.dao.ArticleDAO;
import com.motozone.article.model.dao.ArticleIdDAO;
import com.motozone.article.model.dao.ArticleListDAO;
import com.motozone.article.model.dao.CategoryDAO;
import com.motozone.article.model.dao.CategoryStageDAO;
import com.motozone.article.model.dao.CategoryTranslateDAO;

@Service
@Transactional
public class ArticleService {
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private ArticleIdDAO articleIdDAO;
	@Autowired
	private ArticleListDAO articleListDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private CategoryStageDAO categoryStageDAO;
	@Autowired
	private CategoryTranslateDAO categoryTranslateDAO;

	
	Integer pageSize = 50;
	String  order = "desc";
	
	public ArticleIdBean getId(String title,String category,String url) {
		// initial id
		Integer id = 0;
			
		
		// if url already exist, then return its id
		if(articleIdDAO.selectByUrl(url) != null) {
			return articleIdDAO.selectByUrl(url);
		}
		
		// else , qurey this id until make sure no one use it 
		do {
			id = ((int)(Math.random()*900000) + 100000);
			
			// if id do not exist , insert new id , and break the loop
			if(articleIdDAO.selectById(id) == null) {
				articleIdDAO.insert(new ArticleIdBean(id,title,categoryDAO.getCategory(category),url));
				break;
			}
		
		} while(true);
			
		return articleIdDAO.selectById(id);
	}
	
	public List<CategoryStageBean> getSubcategory(String category) {
		return categoryStageDAO.getSubcategory(categoryDAO.getCategory(category));
	}
	
	public List<ArticleBean> getPosts(Integer id,Integer page){
		List<ArticleBean> list = null;
		
		list = articleDAO.getArticles(articleIdDAO.selectById(id),pageSize, page);
		articleIdDAO.updateViewsById(id);
		
		return list;
	}
	
	public List<ArticleListBean> getPostList(String category,Integer page){
		List<ArticleListBean> list = articleListDAO.getArticleList(category,pageSize, page);
		
		// shorten content
		
		return list;
	}
	
	public boolean addPost(ArticleBean bean) {
		return articleDAO.insert(bean);
	}
	
	public boolean addPosts(List<ArticleBean> list) {
		return articleDAO.insert(list);
	}
	
	public String getCategoryCode(String categoryName, String source) {
		return categoryTranslateDAO.getCategoryCode(categoryName, source)
				.getCategory().getCategory();
	}
}
