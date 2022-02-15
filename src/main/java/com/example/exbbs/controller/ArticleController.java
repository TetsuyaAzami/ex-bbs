package com.example.exbbs.controller;

import java.util.List;
import com.example.exbbs.domain.Article;
import com.example.exbbs.form.ArticleForm;
import com.example.exbbs.form.CommentForm;
import com.example.exbbs.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService service;

	@ModelAttribute
	public ArticleForm setUpArticleForm() {
		return new ArticleForm();
	}

	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}

	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = service.findAll();
		model.addAttribute("articleList", articleList);
		return "bbs";
	}

	@RequestMapping("/insert")
	public String insert(ArticleForm articleForm, Model model) {
		Article article = new Article();
		System.out.println(articleForm.getName());
		System.out.println(articleForm.getContent());
		BeanUtils.copyProperties(articleForm, article);
		service.insert(article);
		return index(model);
	}
}
