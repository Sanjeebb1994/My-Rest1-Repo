package geneicUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class BaseApiClass {
	
	public DatabaseUtility dlib=new DatabaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredUtility rlib=new RestAssuredUtility();
	
	@BeforeSuite
		public void openDB() throws SQLException {
			 baseURI = "http://localhost:8084";
			 port=8084;
			 
			 dlib.connectToDatabase();
			 System.out.println("========== Establish Connection To DB ============");
		}
	
	@AfterSuite
		public void closeDB() throws SQLException {
		
		dlib.closeDB();
		System.out.println("=========== Close DB ==========");
	}
	
}
