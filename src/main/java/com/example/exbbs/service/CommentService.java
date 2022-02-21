package com.example.exbbs.service;

import com.example.exbbs.domain.Comment;
import com.example.exbbs.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repository;

	public void insert(Comment comment) {
		repository.insert(comment);
	}

	// public void deleteByArticleId(Integer articleId) {
	// repository.deleteByArticleId(articleId);
	// }
}
