package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	
	@Test
	public void updateProject(){
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "babul");
		jobj.put("projectName", "DRDO");
		jobj.put("status", "Pending");
		jobj.put("teamSize", 898);
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1006")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(200)
			.log().all();
	}
	
	
}
