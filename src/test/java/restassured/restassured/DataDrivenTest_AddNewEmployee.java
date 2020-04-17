/**
 * 
 */
package restassured.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

/**
 * @author gslab
 *
 */
public class DataDrivenTest_AddNewEmployee {

	@Test
	public void addNewEmployee() {
		
		RestAssured.baseURI="http://dummy.restapieample.com/api/v1/";
		
		RequestSpecification request=RestAssured.given();
		
		//Data which is send as part of POST request
		JSONObject para=new JSONObject();
		para.put("name","Mayur");
		para.put("salary","50000");
		para.put("age","50");
		
		//Means above data is in json format
		request.header("Content-Type","application/json");
		
	}
}
