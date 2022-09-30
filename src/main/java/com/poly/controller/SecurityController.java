package com.poly.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.poly.dao.OrderDAO;
import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.service.AccountService;
import com.poly.service.OrderService;

@Controller
public class SecurityController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDAO orderdao;

	@RequestMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lÃ²ng Ä‘Äƒng nháº­p!");
		return "security/login";
	}

	@RequestMapping("/login/success")
	public String loginSuccess(Model model, HttpServletRequest request ,@RequestParam("p") Optional<Integer> p) {
		String username = request.getRemoteUser();
		model.addAttribute("user", accountService.findById(username));
		
		Pageable pageable = PageRequest.of(p.orElse(0), 6);
		Page<Order> page = orderService.findAll(pageable);
		//System.out.println("username: "+username);
		model.addAttribute("orders", page);
		
		
		model.addAttribute("message", "Ä�Äƒng nháº­p thÃ nh cÃ´ng!");
		return "security/user/layout_success";
	}
	@RequestMapping("/login/success2")
	public String loginSuccess2(Model model, HttpServletRequest request,@RequestParam("p") Optional<Integer> p) {
		String username = request.getRemoteUser();
		model.addAttribute("user", accountService.findById(username));
		Pageable pageable = PageRequest.of(p.orElse(0), 6);
		Page<Order> page = orderService.findAll(pageable);
		//System.out.println("username: "+username);
		model.addAttribute("orders", page);
		model.addAttribute("message", "Ä�Äƒng nháº­p thÃ nh cÃ´ng!");
		return "security/user/layout_success2";
	}
	@RequestMapping("/login/success2/{id}")
	public String change(@PathVariable("id") Integer id,Model model,HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("order", orderService.findById(id));
		orderdao.acceptById(id);
		model.addAttribute("user", accountService.findById(username));
		model.addAttribute("orders", orderService.findAll());
		return "security/user/layout_success2";
	}
	@RequestMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thÃ´ng tin Ä‘Äƒng nháº­p!");
		return "security/login";
	}

	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "KhÃ´ng cÃ³ quyá»�n truy xuáº¥t!");
		return "security/login";
	}

	@RequestMapping("/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Báº¡n Ä‘Ã£ Ä‘Äƒng xuáº¥t!");
		return "security/login";
	}

	@RequestMapping("/login/save")
	public String loginSave(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("user", accountService.findById(username));
		accountService.update(null);
		//System.out.println("username: "+username);
		model.addAttribute("orders", orderService.findByUsername(username));
		model.addAttribute("message", "Báº¡n Ä‘Ã£ Ä‘Äƒng xuáº¥t!");
		return "security/user/layout_success";
	}
	
	@CrossOrigin("*")
	@ResponseBody
	@RequestMapping("/rest/security/authentication")
	public Object getAuthentication(HttpSession session) {
		return session.getAttribute("authentication");
	}
	@RequestMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("message", "Vui lÃ²ng Ä‘Äƒng nháº­p!");
		return "security/register";
	}
//	@RequestMapping("/register/regis")
//	public String register(Model model,HttpServletRequest req ,Account acc) {
//		acc.setFullname(req.getParameter("username"));
//		acc.setPassword(req.getParameter("password"));
//		acc.setEmail(req.getParameter("email"));
//		acc.setAvailable(false);
//		accountService.create(acc);
//		model.addAttribute("message", "Vui lÃ²ng Ä‘Äƒng nháº­p!");
//		return "security/register";
//	}
}
