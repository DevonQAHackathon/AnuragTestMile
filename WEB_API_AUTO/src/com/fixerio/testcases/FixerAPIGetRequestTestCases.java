package com.fixerio.testcases;

import java.net.URI;
import arjunasdk.config.RunConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import unitee.annotations.DriveWithDataFile;
import unitee.annotations.TestClass;
import unitee.annotations.TestMethod;
import unitee.assertions.Assertions;
import unitee.interfaces.TestVariables;

@TestClass
public class FixerAPIGetRequestTestCases {
	
	@TestMethod
	public void testByRequestingLatestExchangeData() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io.");
		String uriValue = "http://api.fixer.io/latest";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingHistoricDataBasedOnDate() throws Exception {
		RunConfig.logger().info("Test for requesting specific date exchange rates from fixer.io.");
		String uriValue = "http://api.fixer.io/2000-01-03";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingDataBasedOnSpecificBaseStandards() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io and base value set to USD.");
		String uriValue = "http://api.fixer.io/latest?base=USD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingDataBasedOnSpecificBaseStandardsAndDate() throws Exception {
		RunConfig.logger().info("Test for requesting specific date based exchange rates from fixer.io with base value set to USD.");
		String uriValue = "http://api.fixer.io/2001-01-03?base=USD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingSingleBaseValue() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io and single Symbols value equal to USD.");
		String uriValue = "http://api.fixer.io/latest?symbols=USD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingSingleBaseValueAndSpecificDate() throws Exception {
		RunConfig.logger().info("Test for requesting specific date based exchange rates from fixer.io based on Symbols value equal to USD.");
		String uriValue = "http://api.fixer.io/2001-01-03?symbols=USD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingMultipleBaseValues() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io based on mltiple Symbols Value equals to USD and AUD.");
		String uriValue = "http://api.fixer.io/latest?symbols=USD,AUD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingSpecificBaseStandardAndSymbolValue() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io with Base standard set to AUD and Symbols set to CZK.");
		String uriValue = "http://api.fixer.io/latest?base=AUD&symbols=CZK";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingSpecificBaseStandardAndMultipleSymbolValues() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io with Base standard set to AUD and Symbols set to CZK and USD as multi values.");
		String uriValue = "http://api.fixer.io/latest?base=AUD&symbols=CZK,USD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@TestMethod
	public void testByRequestingSameValuesOfBaseStandardAndSymbolsValue() throws Exception {
		RunConfig.logger().info("Test for requesting latest exchange rates from fixer.io with Base standard set to AUD and Symbols to AUD.");
		String uriValue = "http://api.fixer.io/latest?base=AUD&symbols=AUD";
		RunConfig.logger().info("Current uri value : " + uriValue);
		URI uri = new URI(uriValue);
		RunConfig.logger().info("Generating and sending get request.");
		Response res = RestAssured.given().get(uri);
		RunConfig.logger().info("Request sent successfully : " + (res.getStatusCode() == 200));
		Assertions.assertTrue("Is request handeled successfully : ", (res.getStatusCode() == 200));
	}
	
	@DriveWithDataFile("fixerInput.ini")
	public void requestingExchangeDataBasedOnDifferentDateEntries(TestVariables tvars) throws Exception{
		String dateValue = tvars.record().string("date");
		String expectedStatusLine = tvars.record().string("expectedStatusLine");
		Integer expectedStatus = tvars.record().value("expectedStatus").asInt();
		String uriValue = "http://api.fixer.io/" + dateValue;
		URI uri = new URI(uriValue);
		Response res = RestAssured.given().get(uri);
		Assertions.assertTrue("Are expected and Actual status codes same :", (res.statusCode()==expectedStatus));
		Assertions.assertTrue("Are expected and Actual status lines matched : ", res.statusLine().equals(expectedStatusLine));
	}
	
}
