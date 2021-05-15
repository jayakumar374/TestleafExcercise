package Week5Day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends BaseTest {

	@Test
	public  void mergelead() throws InterruptedException {
		
		//To CLick create contacts
		driver.findElement(By.linkText("Leads")).click();
		//To click on merge contact using xpath
		driver.findElement(By.linkText("Merge Leads")).click();
		//To CLiclk from widget
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Thread.sleep(2000);
			//To click first window and switch window
		Set<String> ParentWindow = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(ParentWindow);
		driver.switchTo().window(window1.get(1));
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//TO click to widget and switch back to parent window
		driver.switchTo().window(window1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(2000);
		//TO click second window and second record
		ParentWindow = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(ParentWindow);
		driver.switchTo().window(window2.get(1));
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]")).click();
		//TO click merge bbutton
		driver.switchTo().window(window2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}

}
