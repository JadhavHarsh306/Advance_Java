package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	boolean addNewProduct(ProductDto p);

	ProductDto getById(int pid);

	boolean updateProduct(ProductDto p);

	boolean deleteById(int pid);

	List<ProductDto> findByCategory(int cid);

}
