package com.chainsys.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class Service {

	@RequestMapping("/welcome")

	public String welcomePage() {
		return "<h1>Welcome</h1>";
	}

	@RequestMapping("/home")
	public String homePage() {
		String html = "<div>HELLO</div>";
		return html;

	}
	@RequestMapping("/getdata")
	public String getData(@RequestParam(value="City ",defaultValue="Madurai")String City) {
		return "<h1>Welcome to"+City+"</h1>";
		
	}
}
