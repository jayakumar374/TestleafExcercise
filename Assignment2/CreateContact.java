package Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//To CLick create contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Jayakumar");
		driver.findElement(By.id("lastNameField")).sendKeys("JK");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("VAN");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("MATHI");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("CSE");
		driver.findElement(By.id("createContactForm_description")).sendKeys("TEST DESC");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("vanmathi@gmail.com");
		//.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("MATHI");
		Select state = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		state.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		//TO edit contacts
		driver.findElement(By.className("subMenuButton")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("updateContactForm_importantNote");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String result = driver.getTitle();
		System.out.println(result);
		driver.close();
		
		
	}

}
