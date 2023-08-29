package api.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {


	
	@Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd, String phone)
	{

		user userPayload = new user();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(lname);
		userPayload.setPassword(email);
		userPayload.setPhone(phone);
		Response response = userEndPoints.createUser(userPayload);

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
	}

	@Test(priority=3,dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username)
	{

		Response response = userEndPoints.DeleteUser(username);

		System.out.println("Delete User Data.");

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);



	}

	@Test(priority=2,dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUserData(String username)
	{

		Response response = userEndPoints.GetUser(username);

		//System.out.println("Get User Data.");

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);


	}
}
