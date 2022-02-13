package practice_RestAssured;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAlltheProjectsIDAndValidateWRTDataBase {
	
	@Test
	public void getallprojectid() {
		
	when()
		.get("http://localhost:8084/projects/TY_PROJ_1004")
		
	.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
