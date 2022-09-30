package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//	@RequestMapping({"/", "/home", "/home/index"})
//	public String index() {
//		return "redirect:/product/list";
//	}
//	
	@RequestMapping("/admin/home")
	public String admin() {
		return "redirect:/admin/index.html";
	}
	
	@RequestMapping({"/", "/home", "/home/index"})
	public String index() {
		return "layout/index/index";
	}
	
	@RequestMapping("/home/contact")
	public String contact() {
		return "layout/new/contact";
	}
	
	@RequestMapping("/home/highlights")
	public String highlights() {
		return "layout/new/hightligts";
	}
	
	@RequestMapping("/home/new")
	public String news() {
		return "layout/new/new";
	}
	
}
