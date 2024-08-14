package restassured_Abhay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class createprojectfill {
	@Test
	public void fillform()
	{

ChromeDriver driver = new ChromeDriver();
driver.get("http://49.249.28.218:8091");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.id("username")).sendKeys("rmgyantra");
driver.findElement(By.name("password")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[@type='submit']")).click();
driver.findElement(By.xpath("//a[text()='Projects']")).click();
driver.findElement(By.xpath("//span[text()='Create Project']")).click();
driver.findElement(By.name("projectName")).sendKeys("cwqg");
driver.findElement(By.name("createdBy")).sendKeys("prakash");
WebElement ele = driver.findElement(By.xpath("//label[@class='col-form-label']/following-sibling::select"));
//ele.click();
Select sel=new Select(ele);

sel.selectByVisibleText("Created");
driver.findElement(By.xpath("//input[@value='Add Project']")).click();
driver.quit();
}
}