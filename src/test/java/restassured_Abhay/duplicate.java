package restassured_Abhay;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.ninza.hrm.api.generic.JavaUtility;
import com.ninza.hrm.pojoutility.project_pojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class duplicate {
@Test
public void duplicatepro()
{

	 JavaUtility jlib = new JavaUtility();
		String proj = "tekp"+jlib.getRandomNumber();
	project_pojo poj = new project_pojo("vsghg", proj, "Completed", 0);
	Response res = given().body(poj).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/addProject");
res.then().log().all();
res.then().assertThat().statusCode(201);
String prjna = res.jsonPath().get("projectName");
project_pojo poo = new project_pojo("BC", prjna, "Completed", 0);
res=given().body(poo).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/addProject");
res.then().log().all();
res.then().assertThat().statusCode(409);
}

}
