package geneicUtility;

import io.restassured.response.Response;

/**
	 * This method is use to generate generic method specific to RestAssured.
	 * @author DELL
	 *
	 */
public class RestAssuredUtility {
	/**
	 * This method is use to create JSONPath.
	 * @param resp
	 * @param jsonpath
	 * @return
	 */
	public String getJSONpath(Response resp,String jsonpath) {
		String jasonData=resp.jsonPath().get(jsonpath);
		return jasonData;
	}

}
