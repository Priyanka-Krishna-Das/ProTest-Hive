package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Request;
import org.openqa.selenium.devtools.v139.network.model.RequestId;
import org.openqa.selenium.devtools.v139.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class TC_003_API_Data_CSV extends BaseClass{
	
public static TC_001_LoginTestClass tc1;
	
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//To link requests with responses (so we can capture payloads if needed)
private static ConcurrentHashMap<RequestId, String> requestPayloadMap = new ConcurrentHashMap<>();
private static final Map<RequestId, String> requestMethodMap = new ConcurrentHashMap<>();

	@Test
	 public void setupNetworkLogging() throws IOException, InterruptedException 
	 {
		 //Help to handel network traffic
		

		DevTools devTools = ((HasDevTools) driver).getDevTools();
	        
	        devTools.createSession();

	        
	        //https://chromedevtools.github.io/devtools-protocol/tot/Network
	        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

	      //CSV File setup
	        String csvFilePath = "C:\\Users\\Priyanka D\\git\\repository\\ProTest\\apiCSVs\\api_logs.csv";
	        final PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath, true)); // append mode
	        
	        File csvFile = new File(csvFilePath);
	        if (csvFile.length() == 0) {
	            writer.println("Timestamp,Method,URL,StatusCode,Payload,ResponseBody");
	        }
	        
	        // Listen to all outgoing API requests
	        //event and consumer(reqConsumer- lambda exp we are using)
	        
	        devTools.addListener(Network.requestWillBeSent(), request -> {
	            Request req = request.getRequest();
	            String payload = req.getPostData().orElse("No Payload");
	            requestPayloadMap.put(request.getRequestId(), payload);
	            
	            System.out.println(">> API Request: " + req.getMethod() + " " + req.getUrl());
	           
	        });
	        
	        //Retriving json res data
	        final RequestId[] reqId= new RequestId[1];

	        // Listen to all API responses
	        devTools.addListener(Network.responseReceived(), responseConsumer -> {
	            Response res = responseConsumer.getResponse();
	            reqId[0]= responseConsumer.getRequestId();
	            
	            //System.out.println(">> API Response: " + res.getStatus() + " " + res.getUrl());
	            
	          
	            
	            
	            String url = res.getUrl();
	            int status = res.getStatus();
	            String method = requestMethodMap.getOrDefault(reqId, "UNKNOWN");
	            String payload = requestPayloadMap.getOrDefault(reqId, "No Payload");
	            String responseBody="";
	            String time = LocalDateTime.now().format(dtf);
	            
	            synchronized (TC_003_API_Data_CSV.class) {
                    writer.println(time + "," +
                            method + "," +
                            url + "," +
                            status + "," +
                            payload.replaceAll("[\\r\\n,]+", " ") + "," +
                            responseBody.replaceAll("[\\r\\n,]+", " "));
                    writer.flush();
                }
	            
	            if(res.getUrl().contains("http"))
	            {
	            	
	            	 System.out.println("<< API Response: " + res.getStatus() + " " + res.getUrl());
	            	 //Assert.assertEquals(res.getStatus(), 204);
					
					 //String responseBodys =devTools.send(Network.getResponseBody(reqId[0])).getBody();
					 //System.err.println("Response body: "+responseBodys);
					 //System.out.println("Response body: "+responseBodys);
					 
	            	 
	            }
	        });
	        
	        tc1 = new TC_001_LoginTestClass();
			tc1.TC_001_LoginTest_Admin();
	        
	        try {
	            Thread.sleep(3000); // let network activity happen
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        writer.close();
	        System.out.println("+ API logging complete. File saved at: " + csvFilePath);
	    }
	


}
