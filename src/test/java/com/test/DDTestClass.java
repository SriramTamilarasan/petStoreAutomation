package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.endPoints.ResponseClass;
import com.payload.UserPojoClass;
import com.utilities.DataProviderClass;
import com.utilities.ExtentReport;

import io.restassured.response.Response;

public class DDTestClass extends ExtentReport {
	
	@BeforeMethod
	public void setupTest() {
        setUp();
        test = extent.createTest("DDTest");
    }
	
	@Test(priority = 1, dataProviderClass = DataProviderClass.class, dataProvider = "AllDataMethod")
	public void testPostUser(String id, String username, String fname, String lname, String email, String pwd, String ph) {
		UserPojoClass pojoObj = new UserPojoClass();
		
		pojoObj.setId(Integer.parseInt(id));
		pojoObj.setUserName(username);
		pojoObj.setFirstName(fname);
		pojoObj.setLastName(lname);
		pojoObj.setEmail(email);
		pojoObj.setPassword(pwd);
		pojoObj.setPhone(ph);
		
		
		Response res = ResponseClass.createUser(pojoObj);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		

	}
	
	@Test(priority = 2, dataProviderClass = DataProviderClass.class , dataProvider = "UsernameMethod")
	public void testDeleteUser(String userName) {
		
		Response res = ResponseClass.deleteUser(userName);
		res.then().log().all();
		
	}
	
	@AfterMethod
	public void tearDownTest() {
        tearDown();
    }

}
