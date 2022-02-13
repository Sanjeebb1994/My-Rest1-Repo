package parameterAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathparametersTest {

	
	@Test
	public void pathParameters() {
		given()
			.pathParam("projectID", "TY_PROJ_1002")
		.when()
			.delete("http://localhost:8084/projects/{projectID}")
		.then()
			.log().all();
	}
}
