/**
 * 
 */
package restassured.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

/**
 * @author gslab
 *
 */
public class One {

	@Test
	public void getdetails() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		
	}
}
