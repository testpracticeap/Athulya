package com.RestAssuredAssessment.com.RestAssuredAssessment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AppTest {
	////////////////////////////// GET //////////////////////////////
	
	
	@Test
	public void getData() {
//		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
//		RequestSpecification httpreq = RestAssured.given();
//		Response response = httpreq.request(Method.GET, "");
//		ResponseBody resbody = response.getBody();
//		System.out.println(resbody.asString());

		Response response = RestAssured.given()
					.baseUri("https://reqres.in/api/users?page=2")
					.header("Content-type", "application/json")
				.when()
					.get("")
				.then()
					.log().body()
					.extract().response();
		String statusLine = "HTTP/1.1 200 OK";
		Assert.assertEquals(response.getStatusLine(), statusLine);

	}

	 @Test
	public void getDataUsingJson() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		response = httpreq.get("");
		JsonPath jsonpath = response.jsonPath();
		Object contents = jsonpath.get();
		System.out.println("getDataUsingJson" + contents.toString());
		Assert.assertEquals(200, response.statusCode());
	}

	 @Test
	public void getHeaderResponse() {

//		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
//		RequestSpecification httpreq = RestAssured.given();
//		Response response = httpreq.request(Method.GET, "");
//
//		response = httpreq.get("");
//
//		Headers header = response.headers();

		Headers header = RestAssured.given()
					.baseUri("https://reqres.in/api/users?page=2")
					.header("Content-type", "application/json")
				.when()
					.get("")
				.then()
					.log().body()
					.extract().headers();

		for (Header headr : header) {
			System.out.println("value " + headr.getName() + " " + ":" + headr.getValue());
		}		

	}
	@Test 
	public void getHeadersAtATime() {
		Response response= RestAssured.given()
				.baseUri("https://reqres.in/api/users?page=2")
				.header("Content-type", "application/json")
			.when()
				.get("");
		System.out.println(response.header("Server"));
		System.out.println(response.header("Content-Type"));
		Assert.assertEquals(200, response.statusCode());
				
	}
	@Test
	public void getResponseBody() {
		ResponseBody responseBody= RestAssured.given()
				.baseUri("https://reqres.in/api/users?page=2")
				.header("Content-type", "application/json")
			.when()
				.get("").getBody();
		System.out.println(responseBody.asString());
	}

	 @Test
	public void getWithQueryParam() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.queryParam("page", "2").get("/");
		ResponseBody body = response.body();
		ResponseBody resbody = response.getBody();
		String response1 = resbody.asString();
		JsonPath jpath = new JsonPath(response1);
		String per_page = jpath.getString("per_page");
		System.out.println(per_page);
		
		Assert.assertEquals(200, response.statusCode());
	}
	
	@Test
	public void getWithDeserialization() throws IOException {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");

		String responseBody = response.getBody().asString();
		//jsonpath
		io.restassured.path.json.JsonPath jsonpath = response.jsonPath();
		String number = jsonpath.getString("data[0].email");
		System.out.println(number); // 2
		//jayway
		Object data = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.data[0]");
		System.out.println(data.toString());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);

		TypeReference<HashMap<String, Object>> typeref = new TypeReference<HashMap<String, Object>>() {
		};

		HashMap<String, Object> entry = mapper.readValue(json, typeref);

		for (Entry<String, Object> data1 : entry.entrySet()) {
			System.out.println(" " + data1.getKey() + " :" + data1.getValue());
		}
		
		Assert.assertEquals(200, response.statusCode());
	}
	@Test
	public void getAllDataUsingJsonpath() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");
		JsonPath jsnobject = response.jsonPath();  
		List elems=response.jsonPath().getList("data");
		System.out.println(elems);
		
		for(Object i: elems) {
			System.out.println(i);
		}
		
		Assert.assertEquals(200, response.statusCode());
	}

	//////////////////////////// POST ///////////////////////////////
	@Test
	public void postData() {
//		RestAssured.baseURI = "https://reqres.in/api/users";
//		RequestSpecification httpreq = RestAssured.given();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("email", "abcd@gmail.com");
		jsonObj.put("first_name", "Abcd");
//		httpreq.header("Content-Type", "application/json");
//		httpreq.body(jsonObj.toJSONString());
//
//		Response response = httpreq.post("");
//		System.out.println("The status received: " + response.statusLine());		
//    	ResponseBody body = response.getBody();
//		System.out.println(body.asString());
		Response response = RestAssured.given()
					.baseUri("https://reqres.in/api/users")
					.body(jsonObj.toJSONString())
				.when()
					.post("")
				.then()
					.log().body()
					.extract().response();
		Assert.assertEquals(201, response.statusCode());
	}

	@Test
	public void postDataUsingFile() {
		File file = new File("C:\\Users\\7000032446\\eclipse-workspace\\com.RestAssuredAssessment\\src\\test\\resources\\data.json");
		RestAssured.given()
				.baseUri("https://reqres.in/api")
				.contentType(ContentType.JSON)
				.body(file)
			.when()
				.post("/users")
			.then()
				.log().body().assertThat().statusCode(201);
	}

	@Test
	public void postDataByReadingFile() throws IOException {
		byte[] b = Files.readAllBytes(Paths.get("src/test/resources/data.json"));

		String bdy = new String(b);

		RestAssured.given()
				.baseUri("https://jsonplaceholder.typicode.com")
				.contentType(ContentType.JSON)
				.body(bdy)
			.when()
				.post("/posts")
			.then()
				.log().all()
				.assertThat().statusCode(201);
	}

	////////////////////////// PUT ///////////////////////////

	@Test
	public void putRequest() throws IOException {

		RestAssured.baseURI = "https://reqres.in/api/";
		byte[] b = Files.readAllBytes(Paths.get("src/test/resources/Test.json"));

		// convert byte array to string
		String bdy = new String(b);
		Response response = RestAssured.given().
					header("Content-type", "application/json")
				.and()
					.body(b)
				.when()
					.put("users/2")
				.then()
					.log().all()
					.extract().response();
		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals("morpheus", response.jsonPath().getString("name"));
		Assert.assertEquals("zion resident", response.jsonPath().getString("job"));

	}

	////////////////////////// DELETE ///////////////////////////

	@Test
	public void deleteRequest() {
		RestAssured.baseURI = "https://reqres.in/api/";
		Response response = RestAssured.given()
					.header("Content-type", "application/json")
				.when()
					.delete("users/2")
				.then()
					.extract().response();

		Assert.assertEquals(204, response.statusCode());
	}
	

}
