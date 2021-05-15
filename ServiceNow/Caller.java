package ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Caller {

	public void TC001CreateCaller() throws InterruptedException {
		String first = "Vmathi";
		String last = "jaya";
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 1. Launch ServiceNow application
		driver.get("https://dev103117.service-now.com/navpage.do");
		// 2. Login with valid credentials username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		// 3. Enter Callers in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Caller", Keys.ENTER);
		Thread.sleep(1000);
		// 4. Create new Caller by filling all the fields and click 'Submit'.
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sys_user.first_name")).sendKeys(first);
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("984523");
		driver.findElement(By.id("sys_user.last_name")).sendKeys(last);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		// 5. Search and verify the newly created Caller
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(last, Keys.ENTER);
		WebElement lastname = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody[1]/tr[1]/td[3]/a[1]"));
		System.out.println("last name " + lastname.getText());
		boolean nameVerify = false;
		if (!lastname.getText().isEmpty()) {
			nameVerify = true;
			System.out.println("lastname " + lastname.getText() + " Created");
		} else {
			System.out.println("Order not generated");
		}
		driver.close();
	}
	public void TC002Updatephone() throws InterruptedException {
		String last = "jaya";
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// 1. Launch ServiceNow application
		driver.get("https://dev103117.service-now.com/navpage.do");
		// 2. Login with valid credentials username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		// 3. Enter Callers in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Caller", Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
		Thread.sleep(1000);
		// "4. Modify the Business Phone number for an existing Caller and click update
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(last, Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		driver.findElement(By.id("sys_user.phone")).sendKeys("83000");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		// 5. Verify the update for the caller
		WebElement phone = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody[1]/tr[1]/td[5]"));
		System.out.println("phone number " + phone.getText());
		boolean nameVerify = false;
		if (!phone.getText().isEmpty()) {
			nameVerify = true;
			System.out.println("phone number " + phone.getText() + " updated");
		} else {
			System.out.println("phone number not updated");
		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Caller caller = new Caller();
		//caller.TC001CreateCaller();
		caller.TC002Updatephone();

	}

}
