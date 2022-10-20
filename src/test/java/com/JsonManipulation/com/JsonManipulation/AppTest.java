package com.JsonManipulation.com.JsonManipulation;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AppTest {

	 @Test
	public void getAll() {
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users?page=1").when().get("");
		Object allVals = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.*");
		System.out.println(allVals.toString());
		Object allEmails = com.jayway.jsonpath.JsonPath.read(response.asString(), "$..email");
		System.out.println(allEmails.toString());
		Object emails = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[*].email");
		System.out.println(emails.toString());

	}

	@Test
	public void getEmailsWithConditions() {
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users?page=1").when().get("");
		Object email = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[?(@.id == 1)].email");
		System.out.println(email.toString());
		Object emailsLs = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[?(@.id <= 5)].email");
		System.out.println(emailsLs.toString());
		Object emailsGr = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[?(@.id >= 5)].email");
		System.out.println(emailsGr.toString());

	}
	@Test
	public void getLastRecord() {
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users?page=1").when().get("");
		Object last = com.jayway.jsonpath.JsonPath.read(response.asString(), "$..data[-1]");
		System.out.println(last.toString());
	}
	@Test
	public void getRecordsWithArrayIndex() {
		Response response = RestAssured.given().baseUri("https://reqres.in/api/users?page=1").when().get("");
		Object third = com.jayway.jsonpath.JsonPath.read(response.asString(), "$..data[2]");
		System.out.println(third.toString());
		Object firsttwo = com.jayway.jsonpath.JsonPath.read(response.asString(), "$..data[0,1]");
		System.out.println(firsttwo.toString());
		Object firsttwo2 = com.jayway.jsonpath.JsonPath.read(response.asString(), "$..data[0:4:5]");
		System.out.println(firsttwo2.toString());
	}
	

}
