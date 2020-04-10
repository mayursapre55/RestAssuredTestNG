/**
 * 
 */
package restassured.restassured;

import org.json.simple.JSONObject;
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
public class TC_02_PostRequest {

	@Test
	public void registerSuccessful() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification request=RestAssured.given(); 
		
		//Request Payload along iwth post request
		JSONObject request_para=new JSONObject();
		request_para.put("FirstName","Pooja");
		request_para.put("LastName","Sapre");
		request_para.put("UserName","Mayur123");
		request_para.put("Password","Test@123");
		request_para.put("Email","Mayur@test.com");
		
		request.header("Content-Type","application/json");
		request.body(request_para.toJSONString());
		
		//Send Request
		Response response=request.request(Method.POST,"/register");
		
		//Print Resposne Body
		String reponse_body=response.getBody().asString();
		System.out.println(reponse_body);
		
		//Status Code
		int status_code=response.getStatusCode();
		System.out.println(status_code);
		Assert.assertEquals(status_code, 201);
		
		//Success Code Validation
		String success_code=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(success_code,"OPERATION_SUCCESS");
		
	}
}
