package com.requestchaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTestForGET {

	
	@Test
	public void requestChainingGet() {
		Response responce = when()
			.get("http://localhost:8084/projects");
		String pID =responce.jsonPath().get("[2].projectId");
		System.out.println(pID);
		given()
			.pathParam("projectId", pID)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(204)
			.log().all();
	}
}
