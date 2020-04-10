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
public class TC_03_GetGoogleRequest {

	@Test
	public void googletest() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		RequestSpecification http_request=RestAssured.given();
		
		Response response=http_request.request(Method.GET,"maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	 	
		String response_body=response.getBody().asString();
		System.out.println(response_body);
		
		//Verify Headers
		String content_type=response.header("Content-Type");
		System.out.println(content_type);
		Assert.assertEquals(content_type, "application/xml; charset=UTF-8");
		
				
		
	
	}
}
