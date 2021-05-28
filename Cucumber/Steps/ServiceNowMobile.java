package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class ServiceNowMobile extends BaseTest {
		
	//// 5.Select Apple iphone6s
	@And("Select apple iphone6")
	public void clickIPhone() throws InterruptedException
	{
		
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(1000);
				// driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
				driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
	}
	
	@And("select Allowence")
	public void selectAllowence()
	{
		Select Allowence = new Select(driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")));
		Allowence.selectByValue("unlimited");			
	}
		
	@When("select color")
	public void selectColor() throws InterruptedException
	{
		Select color = new Select(
				driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")));
		color.selectByVisibleText("Rose Gold");
	}
	
	@When("select storage field")
	public void selectStorage() throws InterruptedException
	{
		Select storage = new Select(
				driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]")));
		storage.selectByIndex(2);
	}
	
	@Then("click orde now button")
	
		public void clickOrdernow()
		{
			driver.findElement(By.id("oi_order_now_button")).click();
		}
	
	@Then("verify order placed")
	public void verifyOrder()
	{
		WebElement Reqno = driver.findElement(By.xpath("//a[@id='requesturl']//b[1]"));
		System.out.println("Request Number " + Reqno.getText());
		boolean ReqVerify = false;
		if (!Reqno.getText().isEmpty()) {
			ReqVerify = true;
			System.out.println("Order " + Reqno.getText() + " Generated");
		} else {
			System.out.println("Order not generated");
		}
		driver.close();
	}
	
	
	
}
