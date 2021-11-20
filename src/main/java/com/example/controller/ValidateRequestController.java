package com.example.controller;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.ProductInfo;
import com.example.model.RequestMSTwo;
import com.example.model.RequestToMediator;
import com.example.model.ResponseMSTwo;
import com.example.repository.ProductInfoRepository;

@RestController
public class ValidateRequestController {

	private ProductInfoRepository productInfoRepository;
	
	public ValidateRequestController(ProductInfoRepository productInfoRepository) {
		this.productInfoRepository=productInfoRepository;
	}
	
	@PostMapping(path="/validateRequest", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseMSTwo> validateRequest(@RequestBody RequestMSTwo requestMSTwo) {
		
		
		
		ResponseMSTwo responseMSTwo = new ResponseMSTwo();
		responseMSTwo.setRequestMSTwo(requestMSTwo);
		RpcMediator rpcMediator = new RpcMediator();
		try {
			responseMSTwo=rpcMediator.processRequest(requestMSTwo);
			
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProductId(123);
			productInfo.setproductInfo(responseMSTwo.getItemDescription());
			
			productInfoRepository.save(productInfo);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<ResponseMSTwo> res = new ResponseEntity<ResponseMSTwo>(responseMSTwo, HttpStatus.ACCEPTED);
		
		return res;
	}
	
	
	
}
