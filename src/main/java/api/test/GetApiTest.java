package api.test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetApiTest {

	public static void main(String[] args) {
		
	 RestAssured.baseURI = "https://rahulshettyacademy.com";
	 
	given().queryParam("", "");

	}

}
