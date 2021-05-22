package Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class MyLeads extends BaseTest {
	
	String CapturedName="";
	//To clik Lead
	
	@When("click Leads")
	public void clickLead()
	{
		driver.findElement(By.linkText("Leads")).click();
		
	}
	
	//To click find leads
	@When("click find leads")
	public void clikfindLead()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	//TO clik Emial adress
	@And("clik Email")
	public void clickEmail()
	{
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}
	
	//To enter email
	@And("Type EmailAddress (.*)$")
	public void companyname(String mail)
	{
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(mail);
		
		}
	
	//To clilk find leads button
	@And("click find leads button")
	public void findleadsbutton()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	//To Click first displayed name//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]
	@And("click first displayed name")
	public void firstdisp() throws InterruptedException
	{Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		Thread.sleep(1000);
		
	}
	
	//
	@And("click duplicate lead")
	public void dupleadbutt()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
		 CapturedName= driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println("Captured Name  " + CapturedName);
	}
	@And("click duplicate lead submit button")
	public void dupsubmit()
	{
		driver.findElement(By.xpath("//table//tbody//tr/td//input[@class='smallSubmit']")).click();
	}
	@Then("verify duplicate lead")
	public void verify()
	{
	
		
		String DuplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(DuplicateName.equals(CapturedName))
		{
			System.out.println("Name Verified");
		}
		else
		{
			System.out.println("Name mismatched");
		}
	}
}



