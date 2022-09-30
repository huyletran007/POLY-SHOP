package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.dao.OrderDAO;
import com.poly.service.AccountService;
import com.poly.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	OrderService orderService;
	@Autowired OrderDAO odao;
	
	@GetMapping("checkout")
	public String checkout(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("user", accountService.findById(username));
		return "order/checkout";
	}
	
	@GetMapping("list")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		System.out.println("username: "+username);
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable("id")Integer id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
//	@RequestMapping("detail/{id}")
//	public String change(@PathVariable("id") Integer id,Model model) {
//		model.addAttribute("order", orderService.findById(id));
//		odao.acceptById(id);
//		return "order/detail";
//	}
}
