package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojojjava.POJOClass;

public class CreatedByPOJOClass {

	@Test
	public void create() {
		POJOClass pjc = new POJOClass("Pradeep", "Zet", "Complete", 1200);
		given()
			.body(pjc)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
			
	}
	
}
