package restassured_Abhay;

import static io.restassured.RestAssured.given;

import java.time.Duration;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.generic.DataBaseUtility;
import com.ninza.hrm.api.generic.JavaUtility;
import com.ninza.hrm.pojoutility.project_pojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class addpr_ongoingstatus {
	@Test
	public void run() throws Throwable {

		 JavaUtility jlib = new JavaUtility();
			String proj = "tekp"+jlib.getRandomNumber();
		project_pojo poj = new project_pojo("vsghg", proj, "ONGoing", 0);
		Response res = given().body(poj).contentType(ContentType.JSON).when().post("http://49.249.28.218:8091/addProject");
res.then().log().all();
res.then().assertThat().statusCode(201);
String prjna = res.jsonPath().get("projectName");

res.then().assertThat().body("projectName", Matchers.equalTo(prjna));
String stat = res.jsonPath().get("status");
res.then().assertThat().body("status", Matchers.equalTo(stat));
String  prjid = res.jsonPath().get("projectId");

DataBaseUtility dlib = new DataBaseUtility();
dlib.getDbConnection();
boolean flag = dlib.executeQueryVerifyAndGetData("select * from project", 5, stat);
Assert.assertTrue(flag,"Project in DB is not verified");
ChromeDriver driver = new ChromeDriver();
driver.get("http://49.249.28.218:8091");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.id("username")).sendKeys("rmgyantra");
driver.findElement(By.name("password")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[@type='submit']")).click();
driver.findElement(By.xpath("//a[text()='Projects']")).click();

driver.findElement(By.xpath("//input[@placeholder='Search by Project Id']")).sendKeys(prjid);
String txt = driver.findElement(By.xpath("//td[text()='"+prjid+"']/parent::tr[@class='tr']/descendant::td[.='"+stat+"']")).getText();
Assert.assertEquals(stat, txt);


	}

}
