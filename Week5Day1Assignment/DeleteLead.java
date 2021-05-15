package Week5Day1Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseTest{
@Test(enabled=false)
	public  void deletelead() throws InterruptedException {
		
		// To Click Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("04434553");
				
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// button[text()='Find Leads']
		// div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]
		// (//table[1]//tbody[1]//tr[2]//td[1]//div)[1]
		Thread.sleep(2000);

		String FirstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]"))
				.getText();
		System.out.println("First Lead ID" + FirstLead);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(FirstLead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//boolean recordsDisplay = false;
		boolean recordsDisplay1 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).isDisplayed();
		
		if(!recordsDisplay1)
		{
			System.out.println("Not Verified");
		}
		{
			System.out.println("Verified");
		}
		
		

	}

}
