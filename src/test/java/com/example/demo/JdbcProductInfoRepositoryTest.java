package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.repository.JdbcProductInfoRepository;
import com.example.repository.ProductInfoRepository;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcProductInfoRepositoryTest {

	@Autowired
	JdbcProductInfoRepository productInfoRepository;
	
	private JdbcTemplate jdbcTemplate=Mockito.mock(JdbcTemplate.class);
	@Test
	public void test() {
		ProductInfo productInfo=new ProductInfo();
		
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.any(),Mockito.any())).thenReturn(5);
		productInfoRepository.setJdbcTemplate(jdbcTemplate);
		
		int rowsUpdated = productInfoRepository.save(productInfo);
		
		
		Assert.assertEquals(5, rowsUpdated);
	}
}
