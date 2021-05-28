package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class ServiceNowLogin extends BaseTest {
	//To Launch chrome browser
	
	
	//1. Launch ServiceNow application
	@When("Load service URL {string}")
	public void loadservicenowURL(String url)
	{
		driver.get(url);
	}
	
	@Then("switch to frame")
	public void switchFrame()
	{
		driver.switchTo().frame("gsft_main");
	}
	
	//2. Login with valid credentials username as admin and password as India@123
	@And("Type service username {string}")
	public void enterserviceUSername(String username)
	{
		driver.findElement(By.id("user_name")).sendKeys(username);
	}
	

	@And("Type service password {string}")
	public void servicepassword(String password) {

     driver.findElement(By.id("user_password")).sendKeys(password);
	}
	
	//To Click login button
	@And("click service login button")
	public void serviceclick(){
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@Given("click Myrequest")
	public void ClickMyreq() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='Requests']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		
	}
	
}
