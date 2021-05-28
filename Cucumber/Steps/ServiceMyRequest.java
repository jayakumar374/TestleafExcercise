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

public final class ServiceMyRequest extends BaseTest {
	
	
	//3. Enter Service catalog in filter navigator and press enter 
	@And("click serach button and Type req number (.*)$")
	public void clickSearchandTypeReq(String req )
	{
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(req, Keys.ENTER);
	}
	
	@And("select displayed request number")
	public void clickdisplayedReq() throws InterruptedException
	{
		driver.findElement(By.xpath("//table[@id='sc_request_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
	}
	
	//4.To click on mobiles
	
	@When("update approval field to requested")
	public void updateApproval() throws InterruptedException
	{
		Select Approval = new Select(driver.findElement(By.id("sc_request.approval")));
		Approval.selectByValue("requested");
	}
	
	@And("update request state to approved")
	public void updateReq()
	{
		Select request = new Select(driver.findElement(By.id("sc_request.request_state")));
		request.selectByVisibleText("Approved");
	}
	
	@And("update other fields (.*)$")
	public void updateOther(String text){
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ChildWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow.get(1));
		driver.findElement(By.linkText("Apac")).click();
		driver.switchTo().window(ChildWindow.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sc_request.description")).sendKeys(text);
	}
	
	@Then("update request")
	public void updateRequest()
	{
		driver.findElement(By.id("sysverb_update_bottom")).click();
	}
	
	@When("update approval field to rejected")
	public void clickRejected()
	{
		Select Approval = new Select(driver.findElement(By.id("sc_request.approval")));
		Approval.selectByValue("rejected");
	}
	
	@And("update request state to canceled")
	public void clickCanceled(){
		Select request = new Select(driver.findElement(By.id("sc_request.request_state")));
		request.selectByVisibleText("Closed Cancelled");
	}
	
	@And("select cancel request")
	public void toSelectCancelReq()
	{
		driver.findElement(By.xpath("(//button[text()='Cancel Request'])[2]")).click();
	}
}
