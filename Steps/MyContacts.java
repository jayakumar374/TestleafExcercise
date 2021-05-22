package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyContacts extends BaseTest {
	
	//To click Contacts link
	@When("click contacts")
	public void clickMyContacts()
	{
		driver.findElement(By.linkText("Contacts")).click();	
	}
	
	//To click create contacts
	
	@When("click create contacts")
	public void clickCreateContact()
	{
		driver.findElement(By.linkText("Create Contact")).click();
	}
	
	//TO enter first name
	
	@And("Type firstname (.*)$")
	public void enterFirstName(String FName)
	{
		driver.findElement(By.id("firstNameField")).sendKeys(FName);
		
	}

	//To enter last name
	@And("Type lastname (.*)$")
	public void enterlastName(String LNameS)
	{
		driver.findElement(By.id("lastNameField")).sendKeys(LNameS);
	}
	
	//To enter email
	@And("Type email (.*)$")
	public void enterEmail(String email)
	{
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
	}
	@And("click create contact button")
	public void clickSubmit()
	{
		driver.findElement(By.className("smallSubmit")).click();
	}
	@Then("verify created contacts")
	public void isVerify()
	{
		WebElement verify = driver.findElement(By.xpath("//div[text()[normalize-space()='Custom Fields']]"));
		if(!verify.getText().isEmpty())
		{
			System.out.println("Contact created");
		}
		else
		{
			System.out.println("Contact not created");
		}
	}
}
