package com.WeatherAPITestCases;

import java.net.URI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import arjunasdk.config.RunConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import unitee.annotations.DriveWithDataFile;
import unitee.annotations.TestClass;
import unitee.assertions.Assertions;
import unitee.interfaces.TestVariables;

@TestClass
public class WeatherAPITestCases {
	/**
	 * **
	 * 'idInputForWeatherAPI.ini' location is ProjectPath\autocognite-arjuna\data\sources
	 * 'nameInputForWeatherAPI.ini'location is ProjectPath\autocognite-arjuna\data\sources
	 * @param tvars
	 * @throws Exception
	 */
	
	@DriveWithDataFile("idInputForWeatherAPI.ini")
	public void checkWithRequestingWeatherDataBasedOnID(TestVariables tvars) throws Exception {
		RunConfig.logger().info("Test for retriving weather data for id : " + tvars.record().string("id"));
		String idValue = tvars.record().string("id");
		RunConfig.logger().info("Retriving id value from idInputForWeatherAPI.ini as : " + tvars.record().string("id"));
		String expectedStatusLine = tvars.record().string("expectedStatusLine");
		RunConfig.logger().info("Retriving expected Status Line value from idInputForWeatherAPI.ini as : " + tvars.record().string("expectedStatusLine"));
		Integer expectedStatus = tvars.record().value("expectedStatus").asInt();
		RunConfig.logger().info("Retriving expected Status code value from idInputForWeatherAPI.ini as : " + tvars.record().value("expectedStatus").asInt());
		RunConfig.logger().info("Generating uri after retriving data from idInputForWeatherAPI.ini file.");
		String uriValue = "http://api.openweathermap.org/data/2.5/weather?id=" + idValue + "&APPID=05200e61641d9a9b135a08f8964e5887";
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Making GET Request using " + uriValue + " URI value");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Was request response OK : " + (res.statusCode()==200));
		Assertions.assertTrue("Are expected and Actual status codes same :", (res.statusCode()==expectedStatus));
		Assertions.assertTrue("Are expected and Actual status lines matched : ", res.statusLine().equals(expectedStatusLine));
		RunConfig.logger().info("If response returned correct json check whether that json belongs to particular query.");
		if(expectedStatus == 200) {
			RunConfig.logger().info("Response was OK now verifying json.");
			String idFromResponseBody = getValueFromResponseBody(res, "id");
			RunConfig.logger().info("Is response id same as query made : " + (idFromResponseBody.equals(idValue)));
			Assertions.assertTrue("Are response id same as query made : ", (idFromResponseBody.equals(idValue)));
		}
	}
	
	@DriveWithDataFile("nameInputForWeatherAPI.ini")
	public void checkWithRequestingWeatherDataBasedOnCityName(TestVariables tvars) throws Exception {
		RunConfig.logger().info("Test for retriving weather data for City name : " + tvars.record().string("name"));
		String nameValue = tvars.record().string("name");
		RunConfig.logger().info("Retriving City Name value from idInputForWeatherAPI.ini as : " + tvars.record().string("name"));
		String expectedStatusLine = tvars.record().string("expectedStatusLine");
		RunConfig.logger().info("Retriving expected Status code value from idInputForWeatherAPI.ini as : " + tvars.record().string("expectedStatusLine"));
		Integer expectedStatus = tvars.record().value("expectedStatus").asInt();
		RunConfig.logger().info("Retriving expected Status code value from idInputForWeatherAPI.ini as : " + tvars.record().value("expectedStatus").asInt());
		String uriValue = "http://api.openweathermap.org/data/2.5/weather?q=" + nameValue + "&APPID=05200e61641d9a9b135a08f8964e5887";
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Making GET Request using " + uriValue + " URI value");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Was request response OK : " + (res.statusCode()==200));
		Assertions.assertTrue("Are expected and Actual status codes same :", (res.statusCode()==expectedStatus));
		Assertions.assertTrue("Are expected and Actual status lines matched : ", res.statusLine().equals(expectedStatusLine));
		RunConfig.logger().info("If response returned correct json check whether that json belongs to particular query.");
		if(expectedStatus == 200) {
			RunConfig.logger().info("Response was OK now verifying json.");
			String idFromResponseBody = getValueFromResponseBody(res, "name");
			RunConfig.logger().info("Is response id same as query made : " + (idFromResponseBody.equals(nameValue)));
			Assertions.assertTrue("Are response id same as query made : ", (idFromResponseBody.equals(nameValue)));
		}
	}
	
	private String getValueFromResponseBody(Response res, String value) {
		String jsonString = res.getBody().asString();
		JsonObject jobj = new Gson().fromJson(jsonString, JsonObject.class);
		String result = jobj.get(value).getAsString();
		return result;
	}
}
