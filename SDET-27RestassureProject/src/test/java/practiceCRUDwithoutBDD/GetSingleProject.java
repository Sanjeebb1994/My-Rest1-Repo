package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {

	
	@Test
	public void getSingleProject() {
		
		//step-1: Get Single Test Data
		int expstatus=200;
		Response resp=RestAssured.get("http://localhost:8084/projects/TY_PROJ_1005");
		
		//step-2: print project
		System.out.println(resp.prettyPeek());
		int actstatus=resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
	}
}
