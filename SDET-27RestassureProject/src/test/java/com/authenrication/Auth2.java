package com.authenrication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	@Test
	public void auth2() {
		Response response = given()
			.formParam("client_id", "rmg Yantra")
			.formParam("client_secret", "54fa17e109d9b233118e05d0705e0c31")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri ", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=response.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_Id", "2791")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_Id}/chickens-feed")
		.then()
			.log().all();
	}

}
