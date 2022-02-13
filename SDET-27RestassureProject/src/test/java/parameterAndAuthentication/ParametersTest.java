package parameterAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTest {

	@Test
	public void parameter() {
		given()
			.pathParam("org", "sanjeeb123")
//			.queryParam("sort", "created")
//			.queryParam("per_page", "100")
		.when()
			.get("https://api.github.com/orgs/{org}")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
		
	}
	
}
