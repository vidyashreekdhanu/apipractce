package com.ninza.hrm.api.generic;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.response.Response.*;
/**
 * 
 * @author Deepak
 *
 */
public class JsonUtility {
	FileUtility fLib = new FileUtility();
	/**
	 * read data from excel based on json key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @throws ParseException
	 */

	//To get Jsondata based on json complex xpath
	public String getDataOnJsonPath(Response resp , String jsonXPath) {
		List<Object> list =JsonPath.read(resp.asString(), jsonXPath);
		return list.get(0).toString();
	}
	//To get the xmldata based on xml complex xpath
	public String getDataOnXpathPath(Response resp, String xmlXPath) {
		return resp.xmlPath().get(xmlXPath);
	}
	//To verify the data in jsonbody based on jsonpath
	public boolean VerifyDataOnJsonPath(Response resp, String jsonXpath,String expectedData) {
		List<String> list = JsonPath.read(resp.asString(), jsonXpath);
		boolean flag = false;
		for(String str :list) {
			if(str.equals(expectedData)) {
				System.out.println(expectedData+ "is available ==Pass");
				flag=true;
			}
		}
		if(flag ==false) {
			System.out.println(expectedData+ "is not available ==pass");
		}
		return flag;
	}
	public String getAccessToken() throws Throwable {
		Response res=given()
				.formParam("client_id",fLib.getDataFromPropertiesFile("ClientID"))
				.formParam("client_secret", fLib.getDataFromPropertiesFile("ClientSecret"))
				.formParam("grant_type", "client_credentials")
				.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
				res.then().log().all();
					//capture data from the response 
					String token = res.jsonPath().get("access_token");
					return token;
	}

}


