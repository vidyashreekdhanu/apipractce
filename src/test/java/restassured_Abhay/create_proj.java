package restassured_Abhay;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.generic.DataBaseUtility;
import com.ninza.hrm.api.generic.JavaUtility;
import com.ninza.hrm.pojoutility.project_pojo;

import static io.restassured.RestAssured.*;

import java.time.Duration;
import java.util.Random;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class create_proj {
	 JavaUtility jlib = new JavaUtility();
		String proj = "tekp"+jlib.getRandomNumber();
	@Test
	public void createpr_test()
	{   
	
		project_pojo poj = new project_pojo("vid",proj, "Created",0);
    Response res = given().contentType(ContentType.JSON).body(poj).when()
		.post("http://49.249.28.218:8091/addProject");
		res.then().assertThat().log().all().statusCode(201);
		res.then().body("msg", Matchers.equalTo("Successfully Added"));
		//res.then().assertThat().body(Matchers.lessThanOrEqualTo(4000L));
		//Object pr = JsonPath.read(res.asString(), "projectName");
		String  prjid = res.jsonPath().get("projectId");
		System.out.println(prjid);
		String status = res.jsonPath().get("status");
		res.then().assertThat().body("status", Matchers.equalTo(status));
		res.then().body("projectId",Matchers.equalTo(prjid));
		//DataBaseUtility db = new DataBaseUtility();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8091");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search by Project Id']")).sendKeys(prjid);
		String txt = driver.findElement(By.xpath("//td[text()='"+prjid+"']/parent::tr[@class='tr']/descendant::td[.='"+status+"']")).getText();
		Assert.assertEquals(status, txt);
		
	}
}
	


