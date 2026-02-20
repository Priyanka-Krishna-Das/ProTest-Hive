package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC_007_LoginAPI extends BaseClass{
	
	@Test
	 public void main() {

	        String url = "https://dev-admin.nexotechgl.com";

	        String requestBody = """
	                {
	                    "username": "elena@test.es",
	                    "password": "@Renomadrid26",
	                    "device_id": "devc-123"
	                }
	                """; //Java text block (""") makes JSON readable

	                Response response =
	                    RestAssured
	                    //Given these headers, body, and configuration…
	                        .given()
	                            .header("api_key", "4754CA7CD6391")
	                            .header("api_secrete", "E9352BD2F72415EF5DEE4245185A6")
	                            .header("lang", "en")
	                            .contentType(ContentType.JSON)
	                            .body(requestBody)
	                           // .baseUri("url")
	                            
	                        .when() //action starts here
	                            .post("/user/login") //HTTP method(API endpoint)
	                            
	                        .then() //response validations start here
	                            .extract().response();

	                // Assertions
	                Assert.assertEquals(response.getStatusCode(), 200);
	                Assert.assertEquals(response.jsonPath().get("status"), "success");

	                System.out.println("Response Body:");
	                System.out.println(response.asPrettyString());
	     

	        // Print status code
	        System.out.println("Status Code: " + response.getStatusCode());

	        // Print pretty response
	        System.out.println("Response Body:");
	        System.out.println(response.asPrettyString());
	        
	        //Print token
	        String token = response.jsonPath().getString("data.token");
	        System.out.println("Token = " + token);
	    }

}
