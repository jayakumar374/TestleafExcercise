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

public class DuplicateLead extends BaseTest {
	@DataProvider(name = "TestData")
	public Object[][] fetchCreateLeadData() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
		String data[][] = ReadExcell.readExcellData("Duplicate");
		return data;
		
	}
@Test(dataProvider = "TestData")
	public  void duplicate(String Email) throws InterruptedException {
		
		// To Click Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("//span[text()='Email']")).click();

		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(Email);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// button[text()='Find Leads']
		// (//table[1]//tbody[1]//tr[1]//td[@class='x-grid3-col x-grid3-cell
		Thread.sleep(2000);
		String FirstName = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).getText();
		System.out.println("First Name " + FirstName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().equals("Duplicate Lead"))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title Incorrect");
		}
		
		//driver.findElement(By.linkText("Create Lead")).click();
		String CapturedName = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println("Captured Name  " + CapturedName);
		driver.findElement(By.xpath("//table//tbody//tr/td//input[@class='smallSubmit']")).click();
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