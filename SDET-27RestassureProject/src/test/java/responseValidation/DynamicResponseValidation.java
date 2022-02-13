package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	
	@Test
	public void dinamicverify() {
		String expProjectName="Adhar";
		Response responce=when()
			.get("http://localhost:8084/projects");
		List<String> actProjectName=responce.jsonPath().get("projectName");
		boolean flag=false;
		for(String pname:actProjectName) {
			try {
				if(pname.equals(expProjectName)) {
					flag=true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		responce.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
		Assert.assertEquals(flag, true);
	}
}
