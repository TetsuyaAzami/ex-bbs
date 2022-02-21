package com.example.exbbs.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("like")
public class LIkeCountApiController {
	@Autowired
	private ServletContext application;

	@RequestMapping("count")
	public Map<String, Integer> count(String likeCount, String articleId) {
		Map<String, Integer> map = new HashMap<>();
		Integer likeCountInt = Integer.parseInt(likeCount);
		likeCountInt++;
		// articleIdごとにいいねの数を保存
		application.setAttribute("likeCount" + articleId, likeCountInt);
		map.put("likeCount", likeCountInt);
		return map;
	}
}
