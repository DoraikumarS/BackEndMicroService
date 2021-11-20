package com.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.ProductInfo;

@Repository
public class JdbcProductInfoRepository implements ProductInfoRepository {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcProductInfoRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public ProductInfo save(ProductInfo productInfo) {
		String insertPrepareStatement="insert into requestinfo(RequestId,ProductId,RequestedDate) values(?,?,curdate())";
		jdbcTemplate.update(insertPrepareStatement,
				1,productInfo.getProductId());
		
		return productInfo;
	}

}
