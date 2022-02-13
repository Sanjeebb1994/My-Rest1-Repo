package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	
	@Test
	public void deleteProject() {
		
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_202")
		.then()
			.assertThat().statusCode(204)
			.log().all();
	}
}
