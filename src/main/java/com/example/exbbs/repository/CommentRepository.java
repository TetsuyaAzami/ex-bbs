package com.example.exbbs.repository;

import java.util.List;
import com.example.exbbs.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CommentRepository {

	// @Autowired
	// private NamedParameterJdbcTemplate template;

	// public void insert(Comment comment) {
	// String sql =
	// "INSERT INTO comments (name,content,article_id) VALUES (:name,:content,:articleId);";
	// SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
	// template.update(sql, param);
	// }
	@Insert("INSERT INTO comments (name,content,article_id) VALUES (#{name},#{content},#{articleId});")
	void insert(Comment comment);

	@Select("SELECT id,name,content,article_id FROM comments WHERE article_id = #{articleId};")
	List<Comment> selectComments(Integer articleId);

	// public void deleteByArticleId(Integer articleId) {
	// String sql = "DELETE FROM comments WHERE article_id = :id;";
	// SqlParameterSource param = new MapSqlParameterSource().addValue("id", articleId);
	// template.update(sql, param);
	// }
}
