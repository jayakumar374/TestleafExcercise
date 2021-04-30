package Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		// To Click Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div//input[@name='firstName'])[3]")).sendKeys("jayakumar");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		// button[text()='Find Leads']
		// (//table[1]//tbody[1]//tr[1]//td[@class='x-grid3-col x-grid3-cell
		// x-grid3-td-partyId x-grid3-cell-first'])[1]
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tbody//tr[1]//td[1]//a)[1]")).click();
		Thread.sleep(1000);
		String TitlePage = driver.getTitle();

		if (TitlePage.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test  case failed");
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Quadrant");
		driver.findElement(By.className("smallSubmit")).click();
		String ChangedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated company name : " + ChangedName);
		String UpdatedName = ChangedName.replaceAll("[^a-zA-Z]", "");
		System.out.println("Replaced company name : " + UpdatedName);
		if (UpdatedName.equals("Quadrant")) {
			System.out.println("Company verified");
		} else {
			System.out.println("Company not verified");
		}

		driver.close();

	}

}
