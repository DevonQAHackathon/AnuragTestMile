package com.groupkt.testcases;

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
public class GroupKTTestCases {
	
	@DriveWithDataFile("threeLetterCountryTestData.ini")
	public void testByMakingGetRequestToSearchCountryByThreeCharacters(TestVariables tvars) throws Exception {
		RunConfig.logger().info("Test for retriving country data for Three Characters as  : " + tvars.record().string("country"));
		String countryName = tvars.record().string("country");
		RunConfig.logger().info("Retriving Country Name code value from threeLetterCountryTestData.ini as : " + tvars.record().string("country"));
		String expectedStatusLine = tvars.record().string("expectedStatusLine");
		RunConfig.logger().info("Retriving expectedStatusLine value from threeLetterCountryTestData.ini as : " + tvars.record().string("expectedStatusLine"));
		Integer expectedStatus = tvars.record().value("expectedStatus").asInt();
		RunConfig.logger().info("Retriving expectedStatus value from threeLetterCountryTestData.ini as : " + tvars.record().value("expectedStatus").asInt());
		RunConfig.logger().info("Generating uri after retriving data from threeLetterCountryTestData.ini file.");
		String uriValue = "http://services.groupkt.com/country/get/iso3code/" + countryName;
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Making GET Request using " + uriValue + " URI value");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Was request response OK : " + (res.statusCode()==200));
		Assertions.assertTrue("Are expected and Actual status codes same :", (res.statusCode()==expectedStatus));
		Assertions.assertTrue("Are expected and Actual status lines matched : ", res.statusLine().equals(expectedStatusLine));
		if(expectedStatus == 200) {
			RunConfig.logger().info("Response was OK now verifying json.");
			String threeLetterCountryCodeFromResponseBody = getValueFromResponseBody(res, "alpha3_code");
			RunConfig.logger().info("Is response id same as query made : " + (threeLetterCountryCodeFromResponseBody.equals("\"" + countryName + "\"")));
			Assertions.assertTrue("Are response id same as query made : ", (threeLetterCountryCodeFromResponseBody.equals("\"" + countryName + "\"")));
		}
	}
	
	@DriveWithDataFile("twoLetterCountryTestData.ini")
	public void testByMakingGetRequestToSearchCountryByTwoCharacters(TestVariables tvars) throws Exception {
		RunConfig.logger().info("Test for retriving country data for Two Characters as  : " + tvars.record().string("country"));
		String countryName = tvars.record().string("country");
		RunConfig.logger().info("Retriving Country Name code value from twoLetterCountryTestData.ini as : " + tvars.record().string("country"));
		String expectedStatusLine = tvars.record().string("expectedStatusLine");
		RunConfig.logger().info("Retriving expectedStatusLine value from threeLetterCountryTestData.ini as : " + tvars.record().string("expectedStatusLine"));
		Integer expectedStatus = tvars.record().value("expectedStatus").asInt();
		RunConfig.logger().info("Retriving expectedStatus value from threeLetterCountryTestData.ini as : " + tvars.record().value("expectedStatus").asInt());
		RunConfig.logger().info("Generating uri after retriving data from threeLetterCountryTestData.ini file.");
		String uriValue = "http://services.groupkt.com/country/get/iso2code/" + countryName;
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Making GET Request using " + uriValue + " URI value");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Was request response OK : " + (res.statusCode()==200));
		Assertions.assertTrue("Are expected and Actual status codes same :", (res.statusCode()==expectedStatus));
		Assertions.assertTrue("Are expected and Actual status lines matched : ", res.statusLine().equals(expectedStatusLine));
		if(expectedStatus == 200) {
			RunConfig.logger().info("Response was OK now verifying json.");
			String twoLetterCountryCodeFromResponseBody = getValueFromResponseBody(res, "alpha2_code");
			RunConfig.logger().info("Is response id same as query made : " + (twoLetterCountryCodeFromResponseBody.equals("\"" + countryName + "\"")));
			Assertions.assertTrue("Are response id same as query made : ", (twoLetterCountryCodeFromResponseBody.equals("\"" + countryName + "\"")));
		}
	}

	private String getValueFromResponseBody(Response res, String value) {
		String jsonString = res.getBody().asString();
		JsonObject jobj = new Gson().fromJson(jsonString, JsonObject.class);
		String jArray = jobj.get("RestResponse").getAsJsonObject().get("result").getAsJsonObject().get(value).toString();
		return jArray;
	}

}
