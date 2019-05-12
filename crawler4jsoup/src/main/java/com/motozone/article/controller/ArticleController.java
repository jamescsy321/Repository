package com.motozone.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.motozone.article.model.ArticleBean;
import com.motozone.article.model.ArticleListBean;
import com.motozone.article.model.CategoryStageBean;
import com.motozone.article.model.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/Category")
	public String getCategoriesAjax(String category,Model model) {
		List<CategoryStageBean> list = articleService.getSubcategory(category);
		
		model.addAttribute("categoryList", list);
		
		return "ajaxCategory";
		
	}
	
	@RequestMapping("/UserCenter")
	public String getUserCenter() {
		return "userCenterPage";
	}
	
	@RequestMapping("/Categories/{category}")
	public String getCategories(@PathVariable String category,Model model) {
		List<CategoryStageBean> list = articleService.getSubcategory(category);
		
		model.addAttribute("categoryList", list);
		
		
		return "articleCategoryPage";
	}
	
	@RequestMapping(path="/PostList/{category}",method=RequestMethod.GET)
	public String getPostListAjax(@PathVariable String category ,Model model) {
		List<ArticleListBean> list = articleService.getPostList(category, 1);
		
		model.addAttribute("postList", list);
		
		return "postListPage";
		
	}
	
	@RequestMapping(path="/Posts/{id}",method=RequestMethod.GET)
	public String getPost(@PathVariable String id,Model model) {
		List<ArticleBean> list = articleService.getPosts(Integer.valueOf(id),1);
		
		String category = list.get(0).getId().getCategory().getCategory();
		List<ArticleListBean> postList = articleService.getPostList(category, 1);
		
		model.addAttribute("postList", postList);
		
		model.addAttribute("posts", list);
		
		return "postsPage";
		
	}
	
	@RequestMapping(path="/Posts/{id}",method=RequestMethod.POST)
	public String getPostAjax(@PathVariable String id,Model model) {
		List<ArticleBean> list = articleService.getPosts(Integer.valueOf(id),1);
		
		model.addAttribute("posts", list);
		
		return "ajaxPosts";
		
	}
	
	@RequestMapping("/PostList")
	public String getPostListAjax(String category,String page,Model model) {
		List<ArticleListBean> list = articleService.getPostList(category, Integer.valueOf(page));
		
		model.addAttribute("postList", list);
		
		return "ajaxPostList";
		
	}
	
	
	@RequestMapping("/Posts")
	public String getPostAjax(String id,String page,Model model) {
		List<ArticleBean> list = articleService.getPosts(Integer.valueOf(id),Integer.valueOf(page));
		
		model.addAttribute("posts", list);
		
		return "ajaxPosts";
		
	}
}
