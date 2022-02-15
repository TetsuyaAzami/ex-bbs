package com.example.exbbs.repository;

import com.example.exbbs.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
	// private final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
	// Comment comment = new Comment();
	// comment.setId(rs.getInt("id"));
	// comment.setName(rs.getString("name"));
	// comment.setContent(rs.getString("content"));
	// comment.setArticleId(rs.getInt("article_id"));
	// return comment;
	// };

	@Autowired
	private NamedParameterJdbcTemplate template;

	public void insert(Comment comment) {
		String sql =
				"INSERT INTO comments (name,content,article_id) VALUES (:name,:content,:articleId);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		template.update(sql, param);
	}

	public void deleteByArticleId(int id) {
		// String sql = "DELETE FROM articles WHERE id = 1;";
	}
}
