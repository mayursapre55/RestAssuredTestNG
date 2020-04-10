/**
 * 
 */
package restassured.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author gslab
 *
 */
public class TC_04_Get_All_Headers {

	@Test
	public void getAllHeaders() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		RequestSpecification request=RestAssured.given();
		
		Response repsonse=request.request(Method.GET,"https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		String response_body=repsonse.getBody().asString();
		System.out.println("Response body"+response_body);
	
		String header=repsonse.getHeader("Content-Type");
		System.out.println("Header is"+header);
		Assert.assertEquals(header,"application/xml; charset=UTF-8");
		
		String header1=repsonse.getHeader("Pragma");
		System.out.println("Header1 is"+header1);
		Assert.assertEquals(header1,"no-cache");
	
		Headers head=repsonse.getHeaders();
		for(Header h:head) {
			System.out.println(h.getName());
			System.out.println(h.getValue());
		}
			
			
		
	}
	
}
