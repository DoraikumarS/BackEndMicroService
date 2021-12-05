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
	
	public int save(ProductInfo productInfo) {
		System.out.println("Calling DB to insert the ProductInfo");
		String insertPrepareStatement="insert into requestinfo(RequestId,ProductId,RequestedDate) values(?,?,curdate())";
		int rows =jdbcTemplate.update(insertPrepareStatement,
				1,productInfo.getProductId());
		
		return rows;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}
