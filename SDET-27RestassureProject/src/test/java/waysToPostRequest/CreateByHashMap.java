package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateByHashMap {
	
	@Test
	public void creatByHashMap() {
		
		HashMap map = new HashMap();
		map.put("createdBy", "Rajiv");
		map.put("projectName", "Adhar");
		map.put("status", "Complete");
		map.put("teamSize", 2000);
		
		given()
			.body(map)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}
}
