package practice_RestAssured;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ModifyPRojectNAme {

	
	@Test
	public void update() {
				JSONObject jobj=new JSONObject();
				jobj.put("createdBy","deepak");
				jobj.put("createdOn", "10/02/2022");
				jobj.put("projectName", "deepak_pro-99");
				jobj.put("status", "Completed");
				jobj.put("teamSize", 563);
				
			given()
				.body(jobj)
				.contentType(ContentType.JSON)
				
			.when()
				.put("http://localhost:8084/projects/TY_PROJ_1004")
			.then()
				.assertThat()
				.statusCode(200)
				.log().all();		
			}
}
