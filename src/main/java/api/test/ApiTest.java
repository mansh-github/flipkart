package api.test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		// add place
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String place_id = js.getString("place_id");
		System.out.println(place_id);

		// update place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + place_id + "\",\r\n" + "\"address\":\"70 winter walk, USA95\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// get Place
		String address = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
				.header("Content-Type", "application/json").when().get("maps/api/place/get/json").then().log().all()
				.statusCode(200).body("address", equalTo("70 winter walk, USA95"))
				.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

		System.out.println("address = " + address);
		JsonPath js1 = new JsonPath(address);
		System.out.println(js1.get("address"));

	}
}
