package restassured_Abhay;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.ninza.hrm.api.generic.JavaUtility;
import com.ninza.hrm.pojoutility.project_pojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class withoutname {
	@Test
	public void without()
	{

		 JavaUtility jlib = new JavaUtility();
			String proj = "tekp"+jlib.getRandomNumber();
		project_pojo poj = new project_pojo("", proj, "Completed", 0);
		Response res = given().body(poj).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/addProject");
res.then().log().all();
res.then().assertThat().statusCode(201);
String prjna= res.jsonPath().get("projectName");

res.then().assertThat().body("projectName", Matchers.equalTo(prjna));
String stat = res.jsonPath().get("status");
res.then().assertThat().body("status", Matchers.equalTo(stat));
String  prjid = res.jsonPath().get("projectId");
	
	}

}
