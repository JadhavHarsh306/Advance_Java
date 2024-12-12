package com.demo.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.beans.Product;
import com.demo.dto.ProductDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class ProductDTOMapper {
		public static ProductDto mapToProductDto(Product p) {
			if(p.getExpdate()!=null)
			 return new ProductDto(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getExpdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),p.getCid());
			else
				return new ProductDto(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),null,p.getCid());
		}

		public static Product mapToProduct(ProductDto pdto) {
			return new Product(pdto.getPid(),pdto.getPname(),pdto.getQty(),pdto.getPrice(),LocalDate.parse(pdto.getLdtstr(),DateTimeFormatter.ofPattern("dd/MM/yyyy")),pdto.getCid());
		}

	
		
}
