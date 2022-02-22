package com.example.exbbs.repository;

import java.util.List;
import com.example.exbbs.domain.Article;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleRepository {
	// 単純なRow_Mappper
	// // articleオブジェクト
	// private Article article;
	// // 一つ前のレコードのarticleId
	// private int preId = -1;
	// // 今のレコードのarticleId
	// private int id;
	// // articleに紐づくコメントのリスト
	// private List<Comment> commentList;
	// // articleのリスト
	// private List<Article> articleList;

	// private final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {
	// id = rs.getInt("a_id");
	// if (id != preId) {
	// article = new Article();
	// article.setId(rs.getInt("a_id"));
	// article.setName(rs.getString("a_name"));
	// article.setContent(rs.getString("a_content"));
	// article.setCommentList(commentList);z
	// articleList.add(article);
	// preId = rs.getInt("a_id");
	// }
	// Comment comment = new Comment();
	// comment.setId(rs.getInt("c_id"));
	// comment.setName(rs.getString("c_name"));
	// comment.setContent(rs.getString("c_content"));
	// comment.setArticleId(rs.getInt("c_article_id"));
	// commentList.add(comment);
	//
	// return article;
	// };

	// private final ResultSetExtractor<List<Article>> ARTICLE_ROW_MAPPER = (rs) -> {
	// List<Article> articleList = new ArrayList<>();
	// List<Comment> commentList = null;
	// int preId = 0;
	// while (rs.next()) {
	// int id = rs.getInt("a_id");
	// if (id != preId) {
	// Article article = new Article();
	// article.setId(rs.getInt("a_id"));
	// article.setName(rs.getString("a_name"));
	// article.setContent(rs.getString("a_content"));
	// commentList = new ArrayList<>();
	// article.setCommentList(commentList);
	// articleList.add(article);
	// }
	// if (rs.getInt("c_id") != 0) {
	// Comment comment = new Comment();
	// comment.setId(rs.getInt("c_id"));
	// comment.setName(rs.getString("c_name"));
	// comment.setContent(rs.getString("c_content"));
	// comment.setArticleId(rs.getInt("c_article_id"));
	// commentList.add(comment);
	// }
	// preId = id;
	// }
	// return articleList;
	// };
	// @Autowired
	// private NamedParameterJdbcTemplate template;


	// public List<Article> findAll() {
	// StringBuilder sql = new StringBuilder();
	// sql.append("SELECT ");
	// sql.append(
	// "a.id a_id,a.name a_name,a.content a_content,c.id c_id,c.name c_name,c.content
	// c_content,c.article_id c_article_id ");
	// sql.append("FROM ");
	// sql.append("articles a ");
	// sql.append("LEFT OUTER JOIN ");
	// sql.append("comments c ");
	// sql.append("ON ");
	// sql.append("a.id = c.article_id ");
	// sql.append("ORDER BY a.id DESC;");

	// // 単純なRowMapper
	// // articleList = new ArrayList<>();
	// // commentList = new ArrayList<>();
	// // template.query(sql.toString(), ARTICLE_ROW_MAPPER);
	// // return articleList;

	// List<Article> articleList = template.query(sql.toString(), ARTICLE_ROW_MAPPER);
	// return articleList;
	// }

	// mybatis
	@Results(id = "Article", value = {@Result(column = "id", property = "id"),
			@Result(column = "name", property = "name"),
			@Result(column = "content", property = "content"),
			@Result(column = "id", property = "commentList", many = @Many(
					select = "com.example.exbbs.repository.CommentRepository.selectComments"))})
	@Select("SELECT id,name,content FROM articles ORDER BY id DESC LIMIT 10 OFFSET 0")
	List<Article> findAll();

	// @Select("SELECT id,name,content,article_id FROM comments WHERE article_id = #{articleId};")
	// List<Comment> selectComments(Integer articleId);


	// public void insert(Article article) {
	// String sql = "INSERT INTO articles (name,content) VALUES (:name,:content);";
	// SqlParameterSource param = new MapSqlParameterSource().addValue("name", article.getName())
	// .addValue("content", article.getContent());
	// template.update(sql, param);
	// }
	@Insert("INSERT INTO articles (name,content) VALUES (#{name},#{content});")
	void insert(Article article);

	// public void deleteById(Integer articleId) {
	// String sql = "DELETE FROM articles WHERE id = :id;";
	// SqlParameterSource param = new MapSqlParameterSource().addValue("id", articleId);
	// template.update(sql, param);
	// }

	// public void deleteAll(Integer articleId) {
	// StringBuilder sql = new StringBuilder();
	// sql.append("WITH delete_articles AS(DELETE FROM articles WHERE id = :articleId) ");
	// sql.append("DELETE FROM comments WHERE article_id = :articleId;");
	// SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
	// template.update(sql.toString(), param);
	// }
	@Delete("WITH delete_articles AS(DELETE FROM articles WHERE id = #{articleId}) DELETE FROM comments WHERE article_id = #{articleId};")
	void deleteAll(Integer articleId);

}
