package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO dao;
	
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(String productID) {
		return dao.findById(productID).get();
	}

	@Override
	public List<Product> findByCategoryID(String cid) {
		return dao.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		return dao.save(product);
	}

	@Override
	public void delete(String id) {
		dao.deleteById(id);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Page<Product> findByCategoryID(String cid,Pageable pageable) {
		return dao.findByCategoryId(cid,pageable);
	}

	/* Summary Section */
	@Override
	public Long getAvailable() {
		return dao.getAvailable();
	}

	@Override
	public Long getTotalProduct() {
		return dao.count();
	}

	@Override
	public List<Object[]> numberOfProductSoldByType() {
		return dao.numberOfProductSoldByType();
	}

	@Override
	public List<Object[]> getPercentByCate() {
		return dao.getPercentByCate();
	}

	@Override
	public List<Object[]> availableRate() {
		return dao.availableRate();
	}

	@Override
	public List<Object[]> top10Product() {
		return dao.top10Product();
	}
	
	@Override
	public List<Product> findProduct(String request) {
		return dao.findProduct(request); 
	}

}
