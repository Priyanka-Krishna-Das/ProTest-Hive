package com.test;

import java.io.IOException;
import java.util.Optional;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v139.network.model.RequestId;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Request;
import org.openqa.selenium.devtools.v139.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

public class TC_002_APIDevToolsClass extends BaseClass{
	
	//public static ChromeDriver driver;
	
	public static TC_001_LoginTestClass tc1;
	
	@Test
	 public void setupNetworkLogging() throws IOException, InterruptedException 
	 {
		 //Help to handel network traffic
		

		DevTools devTools = ((HasDevTools) driver).getDevTools();
	        
	        devTools.createSession();
	        
	        //https://chromedevtools.github.io/devtools-protocol/tot/Network
	        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

	       
	        // Listen to all outgoing API requests
	        //event and consumer(reqConsumer- lambda exp we are using)
	        
	        devTools.addListener(Network.requestWillBeSent(), request -> {
	            Request req = request.getRequest();
	            
	            System.out.println("➡️ API Request: " + req.getMethod() + " " + req.getUrl());
	           
	            
	        });
	        
	        //Retriving json res data
	        final RequestId[] reqId= new RequestId[1];

	        // Listen to all API responses
	        devTools.addListener(Network.responseReceived(), responseConsumer -> {
	            Response res = responseConsumer.getResponse();
	            reqId[0]= responseConsumer.getRequestId();
	            
	            //System.out.println("⬅️ API Response: " + res.getStatus() + " " + res.getUrl());
	            
	            
	            
	            if(res.getUrl().contains("login"))
	            {
	            	 System.out.println("⬅️ API Response: " + res.getStatus() + " " + res.getUrl());
	            	 //Assert.assertEquals(res.getStatus(), 204);
	            	 String responseBody = devTools.send(Network.getResponseBody(reqId[0])).getBody();
	            	 System.err.println("Response body: "+responseBody);
	            	 System.out.println("Response body: "+responseBody);
	            	 
	            }
	        });
	        
	        tc1 = new TC_001_LoginTestClass();
			tc1.TC_001_LoginTest_Admin();
	        
	        try {
	            Thread.sleep(3000); // let network activity happen
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	
	
//    SoftAssert sa = new SoftAssert();
//    if (res.getStatus().equals("200")) 
//    {
//		sa.assertEquals(res.getStatus(), 200);
//		System.out.println("*****Status getting 200: "+res );
//	}
//    else {
//		System.out.println("*****Status not getting 200: "+res);
//    }



}