package Week5Day2Assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseTest {
	
	@DataProvider(name = "TestData")
	public Object[][] fetchCreateLeadData() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
		String data[][] = ReadExcell.readExcellData("Create");
		return data;
		
	}

@Test(dataProvider = "TestData")
	public  void createlead(String companyName,String firstName, String lastName) {
		
		//To CLick create contacts
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("ASE");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vmathi@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("04434553");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Chennai");
		
		driver.findElement(By.className("smallSubmit")).click();
		//TO edit contacts
		
		
		
		
	}

}