package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Product;
import com.poly.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("/product/category")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if (cid.orElse("").isEmpty()) {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		}else {
			List<Product> list = productService.findByCategoryID(cid.get());
			model.addAttribute("items", list);
		}
		return "product/listsp";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") String id) {
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";	
	}
	@GetMapping("/product")
	public String paginate(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 6);
		Page<Product> page = productService.findAll(pageable);
		model.addAttribute("items",page);
		return "product/listsp";
	}
}
