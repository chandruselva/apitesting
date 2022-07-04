package ibm.apitesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class testing {
@Test
public  void testcase1(){
System.out.println("hi");
Response obj = RestAssured.get("http://localhost:3000/ibmstudents");
System.out.println(obj.asString());
//System.out.println(obj.statusCode());
//System.out.println(obj.headers());
}
@Test(enabled=false)
public  void testcase2(){
	System.out.println("hi");
	Response obj = RestAssured.delete("http://localhost:3000/ibmstudents/3");
	System.out.println(obj.asString());
}
@Test(enabled=false)
public  void testcase3(){
	
	RestAssured.baseURI="http://localhost:3000/";
	given()
	.get("ibmstudents").then().statusCode(200).log().all();
	
	given()
	.delete("ibmstudents/3").then().statusCode(200).log().all();
	
}
@Test(enabled=false)
public  void testcase4(){
	
	RestAssured.baseURI="http://localhost:3000/";
	String bodyvariable ="{\"name\":\"prem\",\"batchno\":\"3232\"}";
	given()
//	.contentType(ContentType.JSON)
	.headers("content-type","application/json")
	.body(bodyvariable).when().post("ibmstudents").
	then().statusCode(201);
//	.log().all();
	}
@Test(enabled=true)
public  void testcase5(){
	
	RestAssured.baseURI="http://localhost:3000/";
	
	JSONObject obj = new JSONObject();
	obj.put("name","chandru");
		obj.put("batchno","27");
	
	System.out.println(obj);
	given()
//	.contentType(ContentType.JSON)
	.headers("content-type","application/json")
	.body(obj.toJSONString()).
	when()
	.put("ibmstudents/4").
	then()
	.statusCode(201)
	.log().all();
}
@Test(enabled=true)
public  void testcase6(){
	
	RestAssured.baseURI="http://localhost:3000/";

	JSONObject obj = new JSONObject();
	obj.put("name","chandru");
//	obj.put("batchno","27");
	
	System.out.println(obj);
	given()
//.contentType(ContentType.JSON)
	.headers("content-type","application/json")
	.body(obj.toJSONString()).
	when()
	.put("ibmstudents/4").
	then()
	.statusCode(200)
.log().all();
}
@Test(enabled=true)
public  void testcase7(){
	
	RestAssured.baseURI="http://localhost:3000/";

	JSONObject obj = new JSONObject();
	obj.put("name","rio");
//	obj.put("batchno","27");
	
	System.out.println(obj);
	given()
//.contentType(ContentType.JSON)
	.headers("content-type","application/json")
	.body(obj.toJSONString()).
	when()
	.patch("ibmstudents/4").
	then()
	.statusCode(200)
.log().all();
}
@Test(enabled=true)
public  void testcase8(){
	
	RestAssured.baseURI="https://petstore.swagger.io/v2/";

	
//	System.out.println(obj);
	given().queryParam("username", "chandru").queryParam("password", "rioraj@55555555").log().all().
	

	when()
	.get("user/login").
	then()
	.statusCode(200)
.log().all();
}
@DataProvider(name="testdata")
public Object[][] data()
{
	Object[][] studentsdata = new Object[2][2];
	studentsdata [0][0]="chandru";
	studentsdata [0][1]="4";
	studentsdata [1][0]="rio";
	studentsdata [1][1]="192";
	return studentsdata;
	
	
}
@Test(enabled=true,dataProvider="testdata")
public  void testcase9(String fname,String btno){
	
	RestAssured.baseURI="http://localhost:3000/";

	JSONObject obj = new JSONObject();
	obj.put("name",fname);
	obj.put("batchno",btno);
	
	System.out.println(obj);
	given()
//.contentType(ContentType.JSON)
	.headers("content-type","application/json")
	.body(obj.toJSONString()).
	when()
	.post("ibmstudents").
	then()
	.statusCode(201)
.log().all();
}
}
