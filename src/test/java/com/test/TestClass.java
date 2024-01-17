package com.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.endPoints.ResponseClass;
import com.endPoints.RoutesClass;
import com.github.javafaker.Faker;
import com.payload.UserPojoClass;

import io.restassured.response.Response;

public class TestClass {
	
	Faker faker;
	UserPojoClass pojoObj;
	
	@BeforeClass
	public void dataSetter() {
		
		faker = new Faker();
		pojoObj = new UserPojoClass();
		pojoObj.setId(faker.idNumber().hashCode());
		pojoObj.setUserName(faker.name().username());
		pojoObj.setFirstName(faker.name().firstName());
		pojoObj.setLastName(faker.name().lastName());
		pojoObj.setEmail(faker.internet().safeEmailAddress());
		pojoObj.setPassword(faker.internet().password(5, 7));
		pojoObj.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		Response res = ResponseClass.createUser(pojoObj);
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		
		Response res = ResponseClass.getUser(this.pojoObj.getUserName());
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		pojoObj.setFirstName(faker.name().firstName());
		pojoObj.setLastName(faker.name().lastName());
		pojoObj.setEmail(faker.internet().safeEmailAddress());
		
		Response res1 = ResponseClass.updateUser(this.pojoObj.getUserName(), pojoObj);
		res1.then().log().all();
		
		//Checking data after update
		Response res2 = ResponseClass.getUser(this.pojoObj.getUserName());
		res2.then().log().body();
		
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		Response res = ResponseClass.deleteUser(this.pojoObj.getUserName());
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 204);
	}
}
