package com.example.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.XmlRpcRequestConfig;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcClientRequestImpl;
import org.springframework.stereotype.Component;

import com.example.model.RequestMSTwo;
import com.example.model.RequestToMediator;
import com.example.model.ResponseMSTwo;

@Component
public class RpcMediator {

	public ResponseMSTwo processRequest(RequestMSTwo requestMSTwo) throws MalformedURLException, XmlRpcException {
		boolean isValidToken = validateToken(requestMSTwo.getTokenToValidate());
		RequestToMediator requestToMediator = new RequestToMediator();
		requestToMediator.setItemName(requestMSTwo.getItemName());
		requestToMediator.setTokenToValidate(requestMSTwo.getTokenToValidate());
		requestToMediator.setIsValidToken(Boolean.toString(isValidToken));
		
		
		XmlRpcClient xmlRpcClient = getXmlRpcClient();
		Object resultMessage = xmlRpcClient.execute("rpc_server.greetingMessage", Arrays.asList(30));
		
		System.out.println("resultMessage is " + resultMessage.toString());
		ResponseMSTwo responseMSTwo = new ResponseMSTwo();
		responseMSTwo.setRequestMSTwo(requestMSTwo);
		responseMSTwo.setItemDescription(resultMessage.toString());
		return responseMSTwo;
	}
	
	public XmlRpcClient getXmlRpcClient() throws MalformedURLException {
		XmlRpcClientConfigImpl xmlRpcClientConfigImpl = new XmlRpcClientConfigImpl();
		xmlRpcClientConfigImpl.setServerURL(new URL("http://localhost:8084"));
		
		XmlRpcClient xmlRpcClient = new XmlRpcClient();
		xmlRpcClient.setConfig(xmlRpcClientConfigImpl);
		
		return xmlRpcClient;
	}
	
	private boolean validateToken(String token) {
		if("sdk".equalsIgnoreCase(token) || "asdfg".equals(token)) {
			return true;
		}
		
		return false;
	}
}
