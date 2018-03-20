/**
 * Hello.java
 * 2017年9月13日
 */
package com.mht.service.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CY
 * @date 2017年9月13日
 */
@Controller
public class Hello {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@RequestMapping("/")
//	public String hello() {
//		logger.info("helllollllllllllllllllllllllllllll");
//		return "Hello world!!!!";
//	}

	@RequestMapping("/HelloWorld")
	public String helloHtml(Map<String, Object> map) {

		map.put("hello", "我们是from TemplateController.helloHtml");
		return "/HelloWorld";
	}
}
