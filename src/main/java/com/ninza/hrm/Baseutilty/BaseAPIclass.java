package com.ninza.hrm.Baseutilty;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza.hrm.api.generic.DataBaseUtility;
import com.ninza.hrm.api.generic.FileUtility;
import com.ninza.hrm.api.generic.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIclass {
	
	public JavaUtility jlib = new JavaUtility();
	public FileUtility flib = new FileUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	public static RequestSpecification specReqobj;
	public static  ResponseSpecification SpecResobj;
	@BeforeSuite
	public void configBS() throws Throwable
	{
		dlib.getDbConnection();
		System.out.println("connect to DB");
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		//builder.setAuth(basic("username", "password"));
		//builder.addHeader("", "");
		builder.setBaseUri(flib.getDataFromPropertiesFile("BASEUri"));
		specReqobj = builder.build();
		ResponseSpecBuilder resbuilder = new ResponseSpecBuilder();
		resbuilder.expectContentType(ContentType.JSON);
		 SpecResobj = resbuilder.build();
	}

@AfterSuite
public void configAS() throws Throwable
{
	dlib.closeDbConnection();
	
}
}
