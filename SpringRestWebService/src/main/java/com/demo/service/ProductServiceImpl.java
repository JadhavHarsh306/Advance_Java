package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dto.ProductDto;
import com.demo.mapper.ProductDTOMapper;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired 
	ProductDao pdao;

	//@Override
	public List<ProductDto> getAllProducts() {
		List<Product> plist= pdao.findAllProducts();
		return plist.stream().map(prod->ProductDTOMapper.mapToProductDto(prod)).collect(Collectors.toList());
	}

	//@Override
	public boolean addNewProduct(ProductDto p) {
		Product p1=ProductDTOMapper.mapToProduct(p);
		return pdao.saveProduct(p1);
		
	}

	//@Override
	public ProductDto getById(int pid) {
		Product p= pdao.findById(pid);
		return ProductDTOMapper.mapToProductDto(p);
	}

	//@Override
	public boolean updateProduct(ProductDto p) {
		Product p1=ProductDTOMapper.mapToProduct(p);
		return pdao.modifyProduct(p1);
	}

	//@Override
	public boolean deleteById(int pid) {
		return pdao.removeById(pid);
	}

	@Override
	public List<ProductDto> findByCategory(int cid) {
		List<Product> plist= pdao.findByCategory(cid);
		return plist.stream()
		.map(prod->ProductDTOMapper.mapToProductDto(prod)).collect(Collectors.toList());
	}

	
}
