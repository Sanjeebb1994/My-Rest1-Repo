package waysToPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatedbyJSONFile {

	
	@Test
	public void createdByJsonFile() {
		File file=new File("./createsarmy.json");
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.contentType(ContentType.JSON)
			.assertThat().statusCode(201)
			.log().all();
	}
}
