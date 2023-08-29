package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class userEndPoints2 {

	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("Routes");//load Routes.properties
		return routes;
	}
	
	public static Response createUser(user payload)
	{
		String post_url = getURL().getString("post_url");
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	}
	
	
	public static Response GetUser(String userName)
	{
		String get_url = getURL().getString("get_url");

		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(get_url);
		
		return response;
	}
	
	
	public static Response UpdateUser(String userName, user payload)
	{
		
		String put_url = getURL().getString("update_url");

		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	
	
	public static Response DeleteUser(String userName)
	{
		String del_url = getURL().getString("delete_url");

		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
			
		
		.when()
		.delete(del_url);
		
		return response;
	}
	
}
