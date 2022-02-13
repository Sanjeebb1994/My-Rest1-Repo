package com.requestchaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTestForPOST {

	@Test
	public void requestChainingTestforPost() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sanjeeb");
		jobj.put("projectName", "SVT56");
		jobj.put("status", "Complete");
		jobj.put("teamSize", 10);
		Response response = given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
			String proId=response.jsonPath().get("projectId");
		given()
			.pathParam("ProjectId", proId)
		.when()
			.get("http://localhost:8084/projects/{ProjectId}")
		.then()
			.assertThat().contentType("SVT_^56")
			.log().all();
				
	}
	
}
