/**
 * 
 */
package restassured.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author gslab
 *
 */
public class TC_06_ValidateJSONResponseAllNodes {

	@Test
	public void validate() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.request(Method.GET,"/Delhi");
		
		String response_body=response.getBody().asString();
		System.out.println(response_body);
		
		JsonPath path=response.jsonPath();
		System.out.println(path.get("City"));
		System.out.println(path.get("Temprature"));
	}
}
