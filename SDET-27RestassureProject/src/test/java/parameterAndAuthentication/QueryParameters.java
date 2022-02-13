package parameterAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameters {
	
	@Test
	public void queryParm() {
		given()
			.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}
