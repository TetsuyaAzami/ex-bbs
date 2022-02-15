package com.example.exbbs.repository;

import java.util.ArrayList;
import java.util.List;
import com.example.exbbs.domain.Article;
import com.example.exbbs.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
	private final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {
		Article article = new Article();
		article.setId(rs.getInt("a_id"));
		article.setName(rs.getString("a_name"));
		article.setContent(rs.getString("a_content"));
		Comment comment = new Comment();
		List<Comment> commentList = new ArrayList();

		return article;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;


	public List<Article> findAll() {
		String sql = "SELECT id,name,content FROM articles;";
		List<Article> articleList = template.query(sql, ARTICLE_ROW_MAPPER);
		return articleList;
	}

	public void insert(Article article) {
		String sql = "INSERT INTO articles (name,content) VALUES (:name,:content);";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", article.getName())
				.addValue("content", article.getContent());
		template.update(sql, param);
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM articles WHERE id = 1;";
	}
}
