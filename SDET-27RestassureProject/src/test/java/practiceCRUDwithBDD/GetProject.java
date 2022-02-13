package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProject {

	
	@Test
	public void getOneProject() {
		
		when()
			.get("http://localhost:8084/projects/TY_PROJ_1006")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(200)
			.log().all();
	}
}
