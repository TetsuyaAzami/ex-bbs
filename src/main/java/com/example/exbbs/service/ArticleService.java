package com.example.exbbs.service;

import java.util.List;

import com.example.exbbs.domain.Article;
import com.example.exbbs.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;

	// public List<Article> findAll() {
	// return repository.findAll();
	// }
	public List<Article> findAll() {
		return repository.findAll();
	}

	// public List<Comment> selectComments(Integer articleId) {
	// return repository.selectComments(articleId);
	// }

	public void insert(Article article) {
		repository.insert(article);
	}

	// public void deleteById(Integer articleId) {
	// repository.deleteById(articleId);
	// }

	public void deleteAll(Integer articleId) {
		repository.deleteAll(articleId);
	}
}
