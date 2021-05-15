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

public class ChangeMnagement {

	public void TC001CreateNewChange() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// To Login the application
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("change", Keys.ENTER);
		// TO CLick new
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
		Thread.sleep(1000);
		// TO CLick NOrmal change
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//div[@class='change-model-card-component'])[2]")).click();
		// To Fill fields
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ChildWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow.get(1));
		driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody[1]/tr[4]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		driver.switchTo().window(ChildWindow.get(0));
		driver.switchTo().frame("gsft_main");
		WebElement changeNo = driver.findElement(By.id("change_request.number"));
		String ChangeNUmber = changeNo.getAttribute("value");
		driver.findElement(By.id("change_request.short_description")).sendKeys("Change Automation");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		// TO get change number

		// TO click open
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		// TO enter change number in search box
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ChangeNUmber, Keys.ENTER);
		WebElement searchchangeno = driver
				.findElement(By.xpath("//table[@id='change_request_table']/tbody[1]/tr[1]/td[3]/a[1]"));
		if (searchchangeno.getText().equals(ChangeNUmber)) {
			System.out.println("Change number :" + searchchangeno.getText() + "  Created");
		} else {
			System.out.println("Change number not created");
		}
		driver.close();

	}

	public void TC002AssesChangeReq() throws InterruptedException {
		String ChangeNUmber = "CHG0030639";
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// To Login the application
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("change", Keys.ENTER);
		// TO CLick new
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ChangeNUmber, Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='change_request_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		Select state = new Select(driver.findElement(By.id("change_request.state")));
		state.selectByIndex(1);
		driver.findElement(By.id("sysverb_update_bottom")).click();
		Thread.sleep(1000);
		WebElement Asearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Asearch.click();
		Asearch.sendKeys(ChangeNUmber, Keys.ENTER);
		WebElement verifyState = driver
				.findElement(By.xpath("//table[@id='change_request_table']/tbody[1]/tr[1]/td[6]"));
		if (!verifyState.getText().equalsIgnoreCase("Assess")) {
			System.out.println("State not Verified :" + verifyState.getText());
		} else {
			System.out.println("State " + verifyState.getText() + " Verified");
		}
		driver.close();
	}

	public void TC003CHangeSchedule() throws InterruptedException {
		String ChangeNUmber = "CHG0030639";
		String date = "2021-05-28 17:00:00";
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// To Login the application
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("change", Keys.ENTER);
		// TO CLick new
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ChangeNUmber, Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='change_request_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Schedule')]")).click();
		WebElement startDate = driver.findElement(By.id("change_request.start_date"));
		startDate.clear();
		startDate.sendKeys(date);
		WebElement endDate = driver.findElement(By.id("change_request.end_date"));
		endDate.clear();
		endDate.sendKeys(date);
		driver.findElement(By.id("label.ni.change_request.cab_required")).click();
		WebElement cabDate = driver.findElement(By.id("change_request.cab_date"));
		cabDate.sendKeys(date);
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[2]")).click();

		WebElement Datesearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Datesearch.click();
		Datesearch.sendKeys(ChangeNUmber, Keys.ENTER);

		WebElement verifyDate = driver
				.findElement(By.xpath("//table[@id='change_request_table']/tbody[1]/tr[1]/td[7]/div[1]"));
		if (verifyDate.getText().contains(date)) {
			System.out.println("Start Date " + date + " Verified");
		} else {
			System.out.println("Date not verified");
		}
		driver.close();

	}

	public void TC004Delete() throws InterruptedException {
		String ChangeNUmber = "CHG0000034";
		// String date = "2021-05-28 17:00:00";
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// To Login the application
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("change", Keys.ENTER);
		// TO CLick new
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ChangeNUmber, Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='change_request_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sysverb_delete_bottom")).click();

		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(1000);
		WebElement Datesearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		Datesearch.click();
		Datesearch.sendKeys(ChangeNUmber, Keys.ENTER);
		WebElement verifyNoRecords = driver.findElement(By.xpath("//td[text()='No records to display']"));
		if (verifyNoRecords.getText().equalsIgnoreCase("No records to display")) {
			System.out.println("Record not found");
		} else {
			System.out.println("Record Available");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ChangeMnagement change = new ChangeMnagement();
		 change.TC001CreateNewChange();
		 change.TC002AssesChangeReq();
		 change.TC003CHangeSchedule();
		change.TC004Delete();
	}

}
