/**
 * 
 */
package restassured.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 * @author gslab
 *
 */
public class TC_01_GET_Request {

	@Test
	public void getWeatherDetails() {
		
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification http_request=RestAssured.given();
		
		//Reponse Object
		Response response=http_request.request(Method.GET,"/Pune");
		
		String response_body=response.getBody().asString();
		
		System.out.println("Response Body is:"+response_body);
		
	}
}
