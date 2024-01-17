package com.endPoints;


//Main url --> https://petstore.swagger.io/
//To create a single user (post)--> https://petstore.swagger.io/v2/user
//To get a single user (get)--> https://petstore.swagger.io/v2/user/{username}
//To update a user (put)--> https://petstore.swagger.io/v2/user/{username}
//To delete a user (delete)--> https://petstore.swagger.io/v2/user/{username}
//					   ------------------------------/---------------
//								    base url             end-point   (sometimes user is also gets changing)

//These above 4 method is called as CRUD methods (creating, retrieving,updating,deleting)
public class RoutesClass {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	

}
