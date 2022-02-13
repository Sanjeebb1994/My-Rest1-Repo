package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojojjava.POJOClass;

public class CreateByDataProvider {

	@Test(dataProvider = "getdata")
	public void create(String createdBy, String projectName,String status,int teamSize) {
		
		POJOClass pojo=new POJOClass(createdBy, projectName, status, teamSize);
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
		
	
	


@DataProvider
public Object[][] getdata() {
	Object[][] objarray=new Object[2][4];
	 objarray[0][0]="Sanjeeb123";
     objarray[0][1]="MVNProject";
     objarray[0][2]="Completed";
     objarray[0][3]=200;
     
     objarray[1][0]="Ranjita";
     objarray[1][1]="GVTProject";
  	 objarray[1][2]="Running";
     objarray[1][3]=1098;
     return objarray;
    }

}













