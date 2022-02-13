package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponceValidation {
	
	@Test
	public void staticValidation() {
		
		String expprojectID="TY_PROJ_001";
		Response respone=when()
			.get("http://localhost:8084/projects");
		String actprojectID=respone.jsonPath().getString("[0].projectId");
		respone.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
		
		Assert.assertEquals(expprojectID, actprojectID);
	}
}
