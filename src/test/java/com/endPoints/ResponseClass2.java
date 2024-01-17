package com.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.payload.UserPojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseClass2 {

	public static Response createUser(UserPojoClass payload){
		
		Response res = given()
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post(RoutesClass.post_url);
	
		return res;
	}
	
	public static Response getUser(String userName){
		
		Response res = given()
			.pathParam("username", userName)
		.when()
			.get(RoutesClass.get_url);
		
		return res;
	}
	
	public static Response updateUser(String userName, UserPojoClass payload){
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(RoutesClass.put_url);
		
		return res;
	}
	
	public static Response deleteUser(String userName){
		
		Response res = given()
			.pathParam("username", userName)
		.when()
			.delete(RoutesClass.delete_url);
		
		return res;
	}

}
