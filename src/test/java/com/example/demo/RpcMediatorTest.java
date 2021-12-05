package com.example.demo;

import java.net.MalformedURLException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.controller.RpcMediator;
import com.example.model.RequestMSTwo;
import com.example.model.ResponseMSTwo;

import junit.framework.Assert;

public class RpcMediatorTest {

	@Test
	public void test_RpcMediator() throws MalformedURLException, XmlRpcException {
		RpcMediator rpcMediator = Mockito.spy(RpcMediator.class);
		
		RequestMSTwo requestMSTwo=new RequestMSTwo();
		requestMSTwo.setItemName("item_name");
		requestMSTwo.setTokenToValidate("dummy_token");
		
		XmlRpcClient xmlRpcClient = Mockito.mock(XmlRpcClient.class);
		Mockito.when(xmlRpcClient.execute(Mockito.anyString(), Mockito.anyList())).thenReturn("Dummy_Value_From_XMPRPC_Server");
		
		Mockito.when(rpcMediator.getXmlRpcClient()).thenReturn(xmlRpcClient);
		
		ResponseMSTwo responseMSTwo= rpcMediator.processRequest(requestMSTwo);
		Assert.assertEquals("Dummy_Value_From_XMPRPC_Server", responseMSTwo.getItemDescription());
	}
}
