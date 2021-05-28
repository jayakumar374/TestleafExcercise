package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class ServiceNowHome extends BaseTest {
	
	
	//3. Enter Service catalog in filter navigator and press enter 
	@And("click ServiceCatalog")
	public void clickServiceCatalog()
	{
		driver.findElement(By.id("filter")).sendKeys("Service catalog",Keys.ENTER);
	}
	
	@And("click Catalog")
	public void clickCatalog()
	{
		driver.findElement(By.xpath("//div[text()='Catalog']")).click();
	}
	
	//4.To click on mobiles
	
	@When("click mobiles and switch to frame")
	public void clickMobileandswitchFrame() throws InterruptedException
	{
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
		Thread.sleep(1000);
	}
	
}
