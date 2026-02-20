package com.rough;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Request;
import org.openqa.selenium.devtools.v139.network.model.RequestId;
import org.openqa.selenium.devtools.v139.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.test.TC_001_LoginTestClass;

public class TestRough extends BaseClass{
	
//	public static TC_001_LoginTestClass tc1;
//	
//	//Format timestamp (yyyy-MM-dd HH:mm:ss)
//    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    String time = LocalDateTime.now().format(dtf);
//
//    // To link requests with responses (so we can capture payloads if needed)
//    private static ConcurrentHashMap<RequestId, String> requestPayloadMap = new ConcurrentHashMap<>();
//    private static ConcurrentHashMap<RequestId, String> requestMethodMap = new ConcurrentHashMap<>();
//    
//
//    @Test
//    public void setupNetworkLogging() throws IOException, InterruptedException {
//        // Initialize DevTools
//        DevTools devTools = ((HasDevTools) driver).getDevTools();
//        devTools.createSession();
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
//
//        // Prepare CSV file
////        String csvDir = System.getProperty("user.dir") + "/apiCSVs";
////        File dir = new File(csvDir);
////        if (!dir.exists()) dir.mkdirs();
//
//        String csvFilePath = "C:\\Users\\Priyanka D\\git\\repository\\ProTest\\apiCSVs\\api_logs.csv";
//        PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath, true));
//
//        // Add header only if the file is new
//        File csvFile = new File(csvFilePath);
//        if (csvFile.length() == 0) {
//            writer.println("Timestamp,Method,URL,StatusCode,Payload,ResponseBody");
//        }
//
//        System.out.println("Logging APIs to: " + csvFilePath);
//
//        
//
//        // Capture outgoing requests
//        devTools.addListener(Network.requestWillBeSent(), request -> {
//            Request req = request.getRequest();
//            String payload = req.getPostData().orElse("No Payload");
//            requestPayloadMap.put(request.getRequestId(), payload);
//            //String method = request.getRequest().getMethod();
//            String method = req.getMethod();
//            
//         // Store both payload and method
//            requestPayloadMap.put(request.getRequestId(), payload);
//            requestMethodMap.put(request.getRequestId(), method);
//
//            
//            System.out.println(">> [" + time + "] " + req.getMethod() + " " + req.getUrl());
//        });
//
//        // ✅ Capture responses
//        devTools.addListener(Network.responseReceived(), responseConsumer -> {
//            Response res = responseConsumer.getResponse();
//            RequestId reqId = responseConsumer.getRequestId();
//            
//            
//
//            try {
//            	String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//                String url = res.getUrl();
//                int status = res.getStatus();
//                String method = requestMethodMap.getOrDefault(reqId, "UNKNOWN");
//                String payload = requestPayloadMap.getOrDefault(reqId, "No Payload");
//                String responseBody;
//                //String time = LocalDateTime.now().format(dtf);
//
//                if (status != 204 && !res.getMimeType().isEmpty()) {
//                    try {
//                        responseBody = devTools.send(Network.getResponseBody(reqId)).getBody();
//                    } catch (Exception e) {
//                        responseBody = "No body available";
//                    }
//                } else {
//                    responseBody = "No body / Preflight request";
//                }
//                
//                
//     
//                synchronized (this) {
//                    writer.println(time + "," +
//                            method + "," +
//                            url + "," +
//                            status + "," +
//                            payload.replaceAll("[\\r\\n,]+", " ") + "," +
//                            responseBody.replaceAll("[\\r\\n,]+", " "));
//                    writer.flush();
//                }
//                
//                
//         
//
//                System.out.println("⬅️ [" + time + "] " + status + " " + url);
//                if (url.contains("login")) {
//                    Assert.assertTrue(status == 200 || status == 204);
//                }
//
//            } catch (Exception e) {
//                System.out.println("⚠️ Error writing to CSV: " + e.getMessage());
//            }
//        });
//
//        // ✅ Run login to trigger API calls
//        tc1 = new TC_001_LoginTestClass();
//        tc1.TC_001_LoginTest_Admin();
//
//        try {
//            Thread.sleep(5000); // let APIs complete
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        writer.close();
//        System.out.println("✅ API logging complete. File saved at: " + csvFilePath);
//    }
	
	
	
	public static TC_001_LoginTestClass tc1;

	// Thread-safe collections for request tracking
	private static final ConcurrentHashMap<String, String> requestMethodMap = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<String, String> requestPayloadMap = new ConcurrentHashMap<>();

	@Test
	public void setupNetworkLogging() throws IOException, InterruptedException {
	    // Initialize DevTools
	    DevTools devTools = ((HasDevTools) driver).getDevTools();
	    devTools.createSession();
	    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

	    // CSV file path - use simple path
	    String csvFilePath = System.getProperty("user.dir") + "\\api_logs.csv";
	    final PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));
	    
	    // Write CSV header
	    writer.println("Timestamp,Method,URL,Status,Payload,Response");
	    System.out.println("📊 Starting network logging to: " + csvFilePath);
	    
	    devTools.send(Network.enable(
	            Optional.of(100000000),  // maxTotalBufferSize
	            Optional.of(100000000),  // maxResourceBufferSize  
	            Optional.of(100000000)   // maxPostDataSize
, java.util.Optional.empty()
	        ));

	        // Counters
	        AtomicInteger requestCount = new AtomicInteger(0);
	        AtomicInteger responseCount = new AtomicInteger(0);

	    // Capture requests - SIMPLIFIED
	    devTools.addListener(Network.requestWillBeSent(), request -> {
	        try {
	        	
	        	int count = requestCount.incrementAndGet();
	            String requestId = request.getRequestId().toString();
	            String method = request.getRequest().getMethod();
	            String url = request.getRequest().getUrl();
	            String payload = request.getRequest().getPostData().orElse("NoPayload");
	            String timestamp = java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
	            
	            // Store request data
	            requestMethodMap.put(requestId, method);
	            requestPayloadMap.put(requestId, payload);
	            
	            System.out.println("📥 RESPONSE #" + count);
	            
	            // Log to console
	            System.out.println("➡️ REQUEST: " + timestamp + " | " + method + " | " + url);
	            
	        } catch (Exception e) {
	            System.out.println("❌ Request error: " + e.getMessage());
	        }
	    });

	    // Capture responses - SIMPLIFIED
	    devTools.addListener(Network.responseReceived(), response -> {
	        try {
	        	
	        	int count = responseCount.incrementAndGet();
	            String requestId = response.getRequestId().toString();
	            String url = response.getResponse().getUrl();
	            int status = response.getResponse().getStatus();
	            String timestamp = java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
	            
	            // Get stored request data
	            String method = requestMethodMap.getOrDefault(requestId, "UNKNOWN");
	            String payload = requestPayloadMap.getOrDefault(requestId, "NoPayload");
	            
	            System.out.println("📥 RESPONSE #" + count);
	            
	            // Get response body
	            String responseBody = "NoBody";
	            try {
	                responseBody = devTools.send(Network.getResponseBody(response.getRequestId())).getBody();
	                if (responseBody == null) responseBody = "NullBody";
	            } catch (Exception e) {
	                responseBody = "BodyError";
	            }
	            
	            // Clean data for CSV (replace commas with pipes)
	            String cleanPayload = payload.replace(",", "|");
	            String cleanResponse = responseBody.replace(",", "|");
	            String cleanUrl = url.replace(",", "|");
	            
	            // Write to CSV
	            String csvLine = timestamp + "," + method + "," + cleanUrl + "," + status + "," + cleanPayload + "," + cleanResponse;
	            
	            synchronized (writer) {
	                writer.println(csvLine);
	                writer.flush();
	            }
	            
	            System.out.println("⬅️ RESPONSE: " + timestamp + " | " + status + " | " + method + " | " + url);
	            
	        } catch (Exception e) {
	            System.out.println("❌ Response error: " + e.getMessage());
	        }
	    });

	    // Run your test
	    System.out.println("🚀 Executing test...");
	    tc1 = new TC_001_LoginTestClass();
	    tc1.TC_001_LoginTest_Admin();
	    
	    // Wait for network calls
	    Thread.sleep(15000);
	    
	    // Cleanup
	    writer.close();
	    devTools.close();
	    System.out.println("✅ Logging complete: " + csvFilePath);
	}
}


