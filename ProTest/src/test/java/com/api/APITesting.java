package com.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class APITesting {
	
	
	//Post api
	//@Test(priority = 1)
    public void loginTest() {

        RestAssured.baseURI = "https://dev-api.hive-system.com";

        String body = "{\n" +
                "    \"username\":\"elena@test.es\",\n" +
                "    \"password\":\"@Renomadrid26\",\n" +
                "    \"device_id\":\"devc-123\"\n" +
                "}";

        Response response =
                given()
                        .header("api_key", "4754CA7CD6391")
                        .header("api_secrete", "E9352BD2F72415EF5DEE4245185A6")
                        .header("lang", "en")
                        .contentType("application/json")
                        .body(body)
                .when()
                        .post("/user/login");
                        
                

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asPrettyString());
        
        //Status Code Assertion
        Assert.assertEquals(response.getStatusCode(), 200);
        
        System.out.println("Login test end");
        System.out.println("_____________________________________________________________________________");
        

    }
	
	
	//Get api
	@Test(priority = 2)
    public void getProfileTest() {
		
		 System.out.println("===== Get Profile Test Started =====");

	        RestAssured.baseURI = "https://dev-api.hive-system.com";

	        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2ODNkN2YwMWQ5NjY1Y2Q0OWQwM2U4MzkiLCJ1c2VyUm9sZSI6IkktVEVDIiwidXNlclR5cGUiOiJpbnRlcm5hbCIsInVzZXJDb21wSWQiOiI2ODNkN2YwMWQ5NjY1Y2Q0OWQwM2U4MzciLCJ1c2VyQ29tcFVzZXJJZCI6IjY4M2Q3ZjAxZDk2NjVjZDQ5ZDAzZTgzNyIsInVzZXJDcmVhdGVkQnkiOiI2ODM0NGRlZDdmYmU5OWE2MTUxMGY4M2EiLCJjcmVhdGVkQXQiOjE3NzE0NDAwMTkwMTMsImlhdCI6MTc3MTQ0MDAxOSwiZXhwIjoxNzcyMDQ0ODE5fQ.8Fv1Uw8VMs-Sn7QrzC1PK7NG3D3E7LJFx5tDwhe6_SI";
	        
	        Response response =
	                given()
	                        .header("api_key", "4754CA7CD6391")
	                        .header("api_secrete", "E9352BD2F72415EF5DEE4245185A6")
	                        .auth().oauth2(token)
	                .when()
	                        .get("/user/profile")
	                .then()
	                        .extract()
	                        .response();

	        // Assertions
	        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch!");
	        Assert.assertNotNull(response.jsonPath().get("data"), "Data is null!");
	        String userId = response.jsonPath().getString("data.id");

	        Assert.assertNotNull(response.jsonPath().getString("data.id"), "UserId is null!");

	        System.out.println("Status Code: " + response.getStatusCode());
	        System.out.println(response.getBody().asPrettyString());
	        
	        System.out.println("User ID: " + userId);

	        System.out.println("===== Get Profile Test End =====");
        
        System.out.println("_____________________________________________________________________________");

	}      
        
        
        
        //@Test(priority = 3)
     // Step 1: Login
        
        public void loginAndGetProfile_Test() {
        	
 
        	System.out.println("**********loginAndGetProfile_Test*************");
        	Response loginResponse =
        	        given()
        	                .header("api_key", "4754CA7CD6391")
        	                .header("api_secrete", "E9352BD2F72415EF5DEE4245185A6")
        	                .contentType("application/json")
        	                .body("{\"username\":\"elena@test.es\",\"password\":\"@Renomadrid26\",\"device_id\":\"devc-123\"}")
        	        .when()
        	                .post("/user/login");

        	System.out.println(loginResponse.getBody().asPrettyString());

        	// Extract correct token
        	String token = loginResponse.jsonPath().getString("data.authToken");

        	System.out.println("New Token: " + token);


        	// PROFILE API
        	Response profileResponse =
        	        given()
        	                .header("api_key", "4754CA7CD6391")
        	                .header("api_secrete", "E9352BD2F72415EF5DEE4245185A6")
        	                .auth().oauth2(token)
        	        .when()
        	                .get("/user/profile");

        	System.out.println("Profile Status Code: " + profileResponse.getStatusCode());
        	System.out.println(profileResponse.getBody().asPrettyString());
        
        
    }

}










//******Basic flow

//Print start message
//
//Set base URL
//
//Add headers
//
//Add token
//
//Send GET request
//
//Store response
//
//Validate status code
//
//Validate JSON fields
//
//Print response
//
//End test


// *******











