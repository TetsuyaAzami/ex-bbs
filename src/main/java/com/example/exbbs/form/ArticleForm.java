package com.example.exbbs.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleForm {
	@NotBlank
	@Size(min = 1, max = 50)
	private String name;
	@NotBlank
	@Size(min = 1, max = 300)
	private String content;
}
