package com.motozone.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.motozone.article.model.ArticleBean;
import com.motozone.article.model.ArticleListBean;
import com.motozone.article.model.service.ArticleService;

@Controller
public class ArticleTestController {
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping("/Article")
	public String getPosts(String id,String page,Model model) {
		
		
		// set error message
		Map<String,String> errMsg = new HashMap<>();
		
		
		// valid check
		if("".equals(id) || id == null) {
			errMsg.put("id", "id number can't be empty");
		}
		
		try {
			Integer.parseInt(id);
		} catch (NumberFormatException e) {
			errMsg.put("id", "id should be a number");
		}
		
		if("".equals(page) || page == null) {
			errMsg.put("page", "page number can't be empty");
		}
		
		try {
			Integer.parseInt(page);
		} catch (NumberFormatException e) {
			errMsg.put("page", "page should be a number");
		}
		
		// if have error message , return to main page
		if(!errMsg.isEmpty()) {
			return "index"; // must return to finish the servlet method
		}
		
		
		// call DAO to get data
//				ArticleDAOJdbc dao = new ArticleDAOJdbc();
		List<ArticleBean> list = null;
		
		list = articleService.getPosts(Integer.parseInt(id), Integer.parseInt(page));
		
		// set result in the list
		model.addAttribute("articles", list);
		
		// redirect
		return "article";
	}
	
	
	@RequestMapping("/Topic")
	public String getArticleList(String page,String cat,Model model) {
		
		// set error message
		Map<String,String> errMsg = new HashMap<>();
		
		
		// valid check
		if("".equals(page) || page == null) {
			errMsg.put("page", "page number can't be empty");
		}
		
		try {
			Integer.parseInt(page);
		} catch (NumberFormatException e) {
			errMsg.put("page", "page should be a number");
		}
		
		// if have error message , return to main page
		if(!errMsg.isEmpty()) {
			return "index"; // must return to finish the servlet method
		}
		
		
		// call DAO to get data
		List<ArticleListBean> list = null;
		
		list = articleService.getPostList(cat, Integer.valueOf(page));
		
		// set result in the list
		model.addAttribute("titles", list);
		
		// redirect
		return "list";
	}
}
