package com.example.demo;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.controller.RpcMediator;
import com.example.controller.ValidateRequestController;
import com.example.model.RequestMSTwo;
import com.example.model.ResponseMSTwo;
import com.example.repository.ProductInfoRepository;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidateRequestControllerTest {

	@Autowired
	private ValidateRequestController validateRequestController;
	
	private ProductInfoRepository productInfoRepository=Mockito.mock(ProductInfoRepository.class);
	
	@Test
	public void test_validateRequestController() {
		RpcMediator rpcMediator = Mockito.mock(RpcMediator.class);
		validateRequestController.rpcMediator=rpcMediator;
		validateRequestController.productInfoRepository=productInfoRepository;
		RequestMSTwo requestMSTwo = new RequestMSTwo();
		requestMSTwo.setItemName("dummy_item_name");
		requestMSTwo.setTokenToValidate("dummy_token");
		
		ResponseMSTwo responseMSTwo=new ResponseMSTwo();
		responseMSTwo.setRequestMSTwo(null);
		responseMSTwo.setItemDescription("Mocked_Dummy_Description");
		
		ProductInfo productInfo=new ProductInfo();
		productInfo.setProductId(12);
		productInfo.setproductInfo("Dummy_Product_Info");
		
		try {
			
			Mockito.when(rpcMediator.processRequest((RequestMSTwo) Mockito.any())).thenReturn(responseMSTwo);
			Mockito.when(productInfoRepository.save((ProductInfo) Mockito.anyObject())).thenReturn(1);
			
			ResponseEntity<ResponseMSTwo> responseEntity = validateRequestController.validateRequest(requestMSTwo);
			
			Assert.assertEquals("Mocked_Dummy_Description", responseEntity.getBody().getItemDescription());
			
			/*System.out.println("responseEntity Details "+ responseEntity.getStatusCode().toString());
			System.out.println("responseEntity Details "+ responseEntity.getBody().toString());
			*/
			//rpcMediator.processRequest(requestMSTwo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
