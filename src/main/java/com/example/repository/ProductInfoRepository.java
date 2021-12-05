package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ProductInfo;

public interface ProductInfoRepository {
	
	int save(ProductInfo productInfo);

}
