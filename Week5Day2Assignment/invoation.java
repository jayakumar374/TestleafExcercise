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

public class invoation extends BaseTest {
	
	

@Test(invocationCount = 5, threadPoolSize = 2)
	public  void createlead() {
		
		//To CLick create contacts
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SBI");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("CHENNAI");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("ROYAPETAH");
		
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("ASE");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vmathi@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("04434553");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Chennai");
		
		driver.findElement(By.className("smallSubmit")).click();
		//TO edit contacts
		
		
		
		
	}

}