package api.test;

public class PayLoad {

	public static String addPlace() {
		
		return "{\r\n"
		 		+ "  \"location\": {\r\n"
		 		+ "    \"lat\": -38.383494,\r\n"
		 		+ "    \"lng\": 33.427362\r\n"
		 		+ "  },\r\n"
		 		+ "  \"accuracy\": 50,\r\n"
		 		+ "  \"name\": \"Frontline house\",\r\n"
		 		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
		 		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
		 		+ "  \"types\": [\r\n"
		 		+ "    \"shoe park\",\r\n"
		 		+ "    \"shop\"\r\n"
		 		+ "  ],\r\n"
		 		+ "  \"website\": \"http://google.com\",\r\n"
		 		+ "  \"language\": \"French-IN\"\r\n"
		 		+ "}";
		
		
	}
	
public static String updatePlace() {
		
		return "{\r\n"
				+ "\"place_id\":\"9eef43d82ee0a02f59e3fe15b74043b2\",\r\n"
				+ "\"address\":\"70 winter walk, USA3\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		
		
	}
	
}
