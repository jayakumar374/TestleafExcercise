package Week4day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		//To Launch Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//TO Launch browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//TO Enter user name and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//TO click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//To CLick create contacts
		driver.findElement(By.linkText("Contacts")).click();
		//To click on merge contact using xpath
		driver.findElement(By.linkText("Merge Contacts")).click();
		//To CLiclk from widget
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		Thread.sleep(2000);
			//To click first window and switch window
		Set<String> ParentWindow = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(ParentWindow);
		driver.switchTo().window(window1.get(1));
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]")).click();
		//TO click to widget and switch back to parent window
		driver.switchTo().window(window1.get(0));
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
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
		//TO accept alert
		driver.switchTo().alert().accept();
		if(driver.getTitle().contains("Merge Contacts"))
		{
			System.out.println("Merge contact verified");
		}
		else
		{
			System.out.println("Merger contact not verified");
		}
		driver.close();
		
		
	}

}
