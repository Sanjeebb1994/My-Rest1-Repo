package com.crm.perfomoperation;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import geneicUtility.BaseApiClass;
import geneicUtility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import pojojjava.POJOClass;

public class CreateTestDataAndVerifyDataBase extends BaseApiClass{
	
	@Test
	public void creteResourceAndVerifyDB() throws SQLException {
		
		//step-1: Create Project Data
		POJOClass pjc=new POJOClass("Sanjeeb1994", "CRM_1"+jlib.randomNumber(), "Completed", 10);
		
		//step-2: Execute PostRequest
		Response res=given()
			.body(pjc)
			.contentType(ContentType.JSON)
		.when()
			.post(EndPoints.createProject);
		
		//step-3 Capture projectId from response
		String expdata=rlib.getJSONpath(res, "projectId");
		System.out.println(expdata);
		
		//step-4: Verify data from DB.
		String query="select * from project;";
		String actdata=dlib.executeQueryAndgetData(query, 1, expdata);
		Reporter.log(actdata);
		
		//step-5  Validate Data
		Assert.assertEquals(expdata, actdata);
		Reporter.log("Data Creation Sucessful", true);
		
	}
}
