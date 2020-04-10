/**
 * 
 */
package restassured.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author gslab
 *
 */
public class TC_05_ValidateJSONResponse {

	@Test
	public void getValidateJSONResponse() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.request(Method.GET,"/Delhi");
		
		String response_body=response.getBody().asString();
		System.out.println(response_body);
		
		Assert.assertEquals(response_body.contains("Delhi"),true);
		
		
	}
}
