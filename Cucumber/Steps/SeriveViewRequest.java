package Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class SeriveViewRequest extends BaseTest {
	
	
	@And("click displayed request number")
	public void clcikorderedReq( )
	{
		driver.findElement(By.xpath("//a[@id='requesturl']//b[1]")).click();
	}
	
	@And("click delete order")
	public void clickDeleteOrder() throws InterruptedException
	{
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		driver.findElement(By.id("ok_button")).click();
	}
	
	
	@Then("verify if the order is deleted")
	public void verifyDeletedReq()
	{
		WebElement VerifyDelete = driver.findElement(By.xpath("//div[@class='notification notification-warning']"));
		System.out.println(VerifyDelete.getText());
		if (VerifyDelete.getText().contains("Order:Empty") &&  VerifyDelete.getText().contains("Close")) {
			System.out.println("Order has been Deleted");
		} else {
			System.out.println("Order existing");
		}
	}
	
	
}
