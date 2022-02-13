package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	
	@Test
	public void updateProject() {
		
		
		//step-1: Create test Data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sanjeeb2");
		jobj.put("projectName", "DELLS");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 12);
		
		//step-2: provide requset specification
		RequestSpecification req=RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//step-3: perform Action
		Response resp=req.put("http://localhost:8084/projects/TY_PROJ_1003");
		
		//step-4: verify
		ValidatableResponse validate=resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
		
	}
}
