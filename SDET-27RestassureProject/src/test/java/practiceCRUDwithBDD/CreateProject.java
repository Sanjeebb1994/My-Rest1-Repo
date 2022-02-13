package practiceCRUDwithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {

	@Test
	public void createProjects() {
		
		Random random=new Random();
		int randomNumber=random.nextInt(100);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Binaya");
		jobj.put("projectName", "VTUF"+randomNumber);
		jobj.put("status", "Continue");
		jobj.put("teamSize", 9);
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
		
	}

}
