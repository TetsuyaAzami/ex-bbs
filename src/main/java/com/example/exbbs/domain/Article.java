package com.example.exbbs.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private Integer id;
	private String name;
	private String content;
	List<Comment> commentList;
}
