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

public class UpdateAndVeifyTestDataFromDatabase extends BaseApiClass{
	
	@Test
	public void updateResourceAndVerifyByDB() throws SQLException {
		
		//Step1: Create data for update
		POJOClass pjc=new POJOClass("Rajib2002", "WHTY_009"+jlib.randomNumber(), "Updated", 345);
		
		//Step2: Execute Post request
		Response res=given()
			.body(pjc)
			.contentType(ContentType.JSON)
		.when()
			.put(EndPoints.updateProject);
		//Step3: CaptureId from response
		String exptData=rlib.getJSONpath(res, "projectId");
		
		//Step4: Verify through DB
		String query="select * from project;";
		String actData=dlib.executeQueryAndgetData(query, 1, exptData);
		Reporter.log(actData);
		
		//Step5: Validate Data
		Assert.assertEquals(exptData, actData);
		Reporter.log("Data Update Sucessful", true);
	}

}
