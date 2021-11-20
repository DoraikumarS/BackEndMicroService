package com.example.demo;

public class Constants {

	
	private static int requestId=1;
	
	public static int getRequestId() {
		return requestId++;
	}
}
