package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	
	@Test
	public void deleteProject() {
		
		//Step-1: 
		int expstatus=204;
		Response resp=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1005");
		
		//step-2: perform Action
		int actstatus=resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println(resp.prettyPeek());
	}
}
