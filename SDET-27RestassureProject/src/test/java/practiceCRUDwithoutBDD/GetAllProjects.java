package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	@Test
	public void getAllProjects() {
		//step-1: Get Test Data
		int expstatus=200;
		Response resp=RestAssured.get("http://localhost:8084/projects");
		
		
		//step-2: print in console and verify
		System.out.println(resp.prettyPeek());
		int actstatus=resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
	}
}
