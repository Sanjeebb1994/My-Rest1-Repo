package practice_RestAssured;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import pojolibrery.New_Pojo_Class;

public class AddSingleProjectWithCreatedStatus {
	
	@Test
	public void addSingleProjectWithCreatedStatus() {
		Random ran =new Random();
		int randomnumber = ran.nextInt(500);
		New_Pojo_Class npj=new New_Pojo_Class("Sanjeeb", "SDET_29A",  "Create", 102);
		String exptProjectname="SDET_29A";
		Response response = given()
			.body(npj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		String proId=response.jsonPath().get("projectName");
		response.then()
			.assertThat().statusCode(201).time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS)
			.contentType(ContentType.JSON)
			.log().all();
		
		Assert.assertEquals(exptProjectname, proId);
	
	}

}
