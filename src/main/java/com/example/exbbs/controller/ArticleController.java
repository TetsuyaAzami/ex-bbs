package com.example.exbbs.controller;

import java.util.List;
import com.example.exbbs.domain.Article;
import com.example.exbbs.domain.Comment;
import com.example.exbbs.form.ArticleForm;
import com.example.exbbs.form.CommentForm;
import com.example.exbbs.service.ArticleService;
import com.example.exbbs.service.CommentService;
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
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

	@ModelAttribute
	public ArticleForm setUpArticleForm() {
		return new ArticleForm();
	}

	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}

	/**
	 * 記事一覧ページ表示
	 *
	 * @param model リクエストスコープ
	 * @return 記事一覧ページ
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = articleService.findAll();
		model.addAttribute("articleList", articleList);
		articleList.forEach(article -> System.out.println(article));
		return "bbs";
	}

	/**
	 * 記事insert
	 *
	 * @param articleForm 記事フォーム情報
	 * @param model リクエストスコープ
	 * @return 記事一覧ページ
	 */
	@RequestMapping("/insertArticle")
	public String insert(ArticleForm articleForm, Model model) {
		Article article = new Article();
		System.out.println(articleForm.getName());
		System.out.println(articleForm.getContent());
		BeanUtils.copyProperties(articleForm, article);
		articleService.insert(article);
		return "redirect:/article";
	}

	/**
	 * コメントデータinsert
	 *
	 * @param commentForm コメントフォーム情報
	 * @param model リクエストスコープ
	 * @return 記事一覧ページ
	 */
	@RequestMapping("/insertComment")
	public String insert(CommentForm commentForm, Model model) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);
		comment.setArticleId(Integer.parseInt(commentForm.getArticleId()));
		commentService.insert(comment);
		commentForm = new CommentForm();
		return "redirect:/article";
	}
}
