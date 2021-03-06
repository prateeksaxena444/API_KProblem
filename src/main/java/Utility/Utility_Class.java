package Utility;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;

import APIs.API_Details;

public class Utility_Class {
     API_Details apd = new API_Details();
     
	 public boolean checkFor200(String api)
	 {
	RestAssured.baseURI = api;
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get();
	String body = response.getBody().asString();
	int status = response.getStatusCode();
	String statusLine = response.getStatusLine();
	System.out.println("Response Body is "+body);
	System.out.println("Status code is "+status);
	System.out.println("Status line is "+statusLine);
	
	if(status==200)
		return true;
	else
		return false;
	 }
	 
	 public boolean validateSchema(String api)
	 {
		 RestAssured.baseURI = api;
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("/?tenant=1kosmos");
			String body = response.getBody().asString();
			System.out.println(body);
			if(body.equals(apd.api_schema))
					{
				    System.out.println("Schema Validation True");
					return true;
					}
			else
				{
				 System.out.println("Schema Validation False");
				return false;
				}
	 }
	 
	 public String getBody(String api)
	 {
	RestAssured.baseURI = api;
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("/?tenant=1kosmos");
	String body = response.getBody().asString();
	return body;
	 }
}
