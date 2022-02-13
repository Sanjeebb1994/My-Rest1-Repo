package geneicUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
	 * This class is use to connect to the database.
	 * @author DELL
	 *
	 */
public class DatabaseUtility {
	Connection con=null;
	//step-1: Register the DB.
	//step-2: get connection to the DB.
	//step-3: issue create Statement.
	//step-4: Execute query to the DB.
	//step-5: Close DB.
	
	/**
	 * This method will connect to DB.
	 * @throws SQLException
	 */
	public void connectToDatabase() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	con=DriverManager.getConnection(IConstant.dbURl,IConstant.dbUserName,IConstant.dbPassword);
	}
	
	/**
	 * This method is use to executeQueryAndgetData from DB.
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndgetData(String query, int columnIndex,String expData) throws SQLException {
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData+"   Data Verified");
			return expData;
		}else {
			return "";
		}
	}
	
	/**
	 * This method will close the DB.
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}
}
