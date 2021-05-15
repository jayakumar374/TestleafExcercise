package Week5Day1Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	ChromeDriver driver;
	@BeforeMethod
	public void login()
	{
		//To Launch Browser
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				//TO Launch browser
				driver.get("http://leaftaps.com/opentaps/control/main");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//TO Enter user name and password
				driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				//TO click CRM/SFA link
				driver.findElement(By.linkText("CRM/SFA")).click();
	}
@AfterMethod
public void closeBrowser()
{
	driver.close();
}
}
