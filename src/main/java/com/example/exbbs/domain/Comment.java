package com.example.exbbs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private Integer id;
	private String name;
	private String content;
	private Integer articleId;
}
