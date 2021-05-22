package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class LoginPage extends BaseTest {
	//To Launch chrome browser
	@Given("Launch Chrome browser")
	public void launchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//To Enter Url
	@When("Load URL {string}")
	public void loadURL(String url)
	{
		driver.get(url);
	}
	
	//To enter user name
	@And("Type username {string}")
	public void enterUSername(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	//To enter password
	@And("Type password {string}")
	public void password(String password) {

     driver.findElement(By.id("password")).sendKeys(password);
	}
	
	//To Click login button
	@And("click login button")
	public void click(){
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	//To click crm sfa link
	@And("click CRMSFA")
	public void clickCRM()
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	//To close browser
	@Then("close chrome browser")
	public void closebrowser()
	{
		driver.close();
	}

}
