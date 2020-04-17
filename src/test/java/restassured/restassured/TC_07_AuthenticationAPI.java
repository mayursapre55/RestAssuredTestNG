/**
 * 
 */
package restassured.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author gslab
 *
 */
public class TC_07_AuthenticationAPI {

	@Test 
	public void getAuthenticate() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.request(Method.GET,"/");
		
		//Status Code
		int status_code=response.getStatusCode();
		System.out.println(status_code);
		Assert.assertEquals(status_code,200);
		
		//Basic Authentication
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		RestAssured.authentication=auth;
		
	}
}
