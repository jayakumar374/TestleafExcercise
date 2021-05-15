package ServiceNow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Week2.day3.Login;
import Week4day7.WindowHandle;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentManagement {

	public void TC01CreateNewIncident() throws InterruptedException {
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		// To Enter value as "Incident"
		WebElement incident = driver.findElement(By.id("filter"));

		incident.sendKeys("Incident");

		incident.sendKeys(Keys.ENTER);
		// driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		// driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ChildWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow.get(1));
		driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		driver.switchTo().window(ChildWindow.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("This is an incident automation test");
		WebElement incNo = driver.findElement(By.xpath("//div[@class='hidden']/following-sibling::input"));
		String searchCOntent = incNo.getAttribute("value");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		System.out.println("Incident number " + searchCOntent);
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		;
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		search.click();
		search.sendKeys(searchCOntent, Keys.ENTER);
		Thread.sleep(2000);
		WebElement searchitem = driver.findElement(By.xpath("//table[@id='incident_table']//tbody//tr[1]//td[3]//a"));
		System.out.println("Search NO" + searchitem.getText());
		if (searchitem.getText().equals(searchCOntent)) {
			System.out.println(searchitem.getText() + "Verified");
		} else {
			System.out.println("Incident number not found");
		}

		driver.close();
	}

	public void TC002UpdateExistingIncident() throws InterruptedException {
		String incNo = "INC0010691";
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		// To Enter value as "Incident"
		WebElement incident = driver.findElement(By.id("filter"));
		incident.sendKeys("Incident");
		incident.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame("gsft_main");
		/*
		 * Select drop = new Select(driver.findElement(By.
		 * xpath("//select[@class='form-control default-focus-outline']")));
		 * drop.selectByValue("Number");
		 */
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		search.click();
		search.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		// Thread.sleep(2000);//table[@id='incident_table']/tbody[1]/tr[1]/td[3]/a[1]
		WebElement in = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println(in.getText());
		in.click();
		// To select Urgency as High
		Thread.sleep(1500);
		Select urgency = new Select(driver.findElement(By.id("incident.urgency")));
		urgency.selectByIndex(0);
		// To select state
		Select state = new Select(driver.findElement(By.id("incident.state")));
		state.selectByIndex(1);
		;
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[2]")).click();
		Thread.sleep(1000);
		WebElement Update = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		Update.click();
		Update.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		driver.findElement(By.xpath("//table[@id='incident_table']//tbody//tr[1]//td[3]//a")).click();
		WebElement VerifyState = driver.findElement(By.xpath("//span[text()='In Progress']"));
		WebElement VerifyUrgency = driver.findElement(By.xpath("//span[text()='3 - Moderate']"));
		if (VerifyState.getText().contains("In Progress") && VerifyUrgency.getText().contains("3 - Moderate")) {
			System.out.println("State " + VerifyState.getText() + " Urgency " + VerifyUrgency.getText() + "  Verified");
		} else {
			System.out.println();
		}
	}

	public void TC003Assign() throws InterruptedException {
		String incNo = "INC0010998";
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		// To Enter value as "Incident"
		WebElement incident = driver.findElement(By.id("filter"));
		incident.sendKeys("Incident");
		incident.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame("gsft_main");
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		search.click();
		search.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		WebElement in = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println(in.getText());
		in.click();
		// To select Urgency as High
		Thread.sleep(1500);
		// To assign to software group
		driver.findElement(By.xpath("//button[@data-for='sys_display.incident.assignment_group']//span[1]")).click();
		Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ChildWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow.get(1));
		WebElement childsearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		childsearch.click();
		childsearch.sendKeys("Software", Keys.ENTER);
		// driver.findElement(By.xpath("//table[@id='sys_user_group_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		driver.findElement(By.linkText("Software")).click();
		Thread.sleep(1000);
		driver.switchTo().window(ChildWindow.get(0));
		// To update work notes

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Auto TEST");
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[2]")).click();
		Thread.sleep(1000);
		//
		WebElement updatesearch = driver
				.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		updatesearch.click();
		updatesearch.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		WebElement AssignedGroup = driver
				.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[10]/a[1]"));
		if (AssignedGroup.getText().equalsIgnoreCase("Software")) {
			System.out.println("Assigned Groups " + AssignedGroup.getText() + " Verified");
		} else {
			System.out.println("Assigned group not verified");
		}
		driver.close();
	}

	public void TC004DeleteIncident() throws InterruptedException {
		//
		String incNo = "INC0010323";
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		// To Enter value as "Incident"
		WebElement incident = driver.findElement(By.id("filter"));
		incident.sendKeys("Incident");
		incident.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame("gsft_main");
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		search.click();
		search.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		WebElement in = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println(in.getText());
		in.click();
		// To select Urgency as High
		Thread.sleep(1500);
		driver.findElement(By.id("sysverb_delete_bottom")).click();

		driver.findElement(By.id("ok_button")).click();

		Thread.sleep(1000);
		WebElement desearch = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		desearch.click();
		desearch.sendKeys(incNo, Keys.ENTER);
	    WebElement verifyNoRecords = driver.findElement(By.xpath("//td[text()='No records to display']"));
	    if(verifyNoRecords.getText().equalsIgnoreCase("No records to display"))
	    {
	    	System.out.println("Record not found");
	    }
	    else
	    {
	    	System.out.println("Record Available");
	    }
driver.close();
	}

	public void TC005Resove() throws InterruptedException
	{
		String incNo = "INC0010261";
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		// To Enter value as "Incident"
		WebElement incident = driver.findElement(By.id("filter"));
		incident.sendKeys("Incident");
		incident.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame("gsft_main");
		Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
		drop.selectByIndex(1);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		search.click();
		search.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		WebElement in = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		System.out.println(in.getText());
		in.click();
		// To select Urgency as High
		Thread.sleep(1500);
		Select state = new Select(driver.findElement(By.id("incident.state")));
		state.selectByIndex(4);
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		Thread.sleep(1000);
		Select resol = new Select(driver.findElement(By.id("incident.close_code")));
		resol.selectByIndex(1);
		driver.findElement(By.id("incident.close_notes")).sendKeys("CLosed");
		driver.findElement(By.id("resolve_incident_bottom")).click();
		WebElement research = driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"));
		research.click();
		research.sendKeys(incNo, Keys.ENTER);
		System.out.println(incNo);
		WebElement resolved = driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[8]"));
		if(resolved.getText().contains(" resolved"))
		{
			System.out.println(incNo + " Has been resolved");
		}
		else
		{
			System.out.println(incNo + " not resolved");
		}
		driver.close();
	}
	public void TC006IncidentwithoutMandatory() throws InterruptedException
	{
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
		WebDriverWait wait = new WebDriverWait(driver, 3);
		// To Enter value as "Incident"
		WebElement incident = driver.findElement(By.id("filter"));

		incident.sendKeys("Incident");

		incident.sendKeys(Keys.ENTER);
		// driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		WebElement verifyText = driver.findElement(By.xpath("(//div[contains(@class,'outputmsg outputmsg_error')]//span)[3]"));
		System.out.println(verifyText.getText());
		if(verifyText.getText().contains("The following mandatory fields are not filled in: Short description, Caller"))
		{
			System.out.println("incident not created : " + verifyText.getText());
		}
		else
		{
			System.out.println("Incident created");
		}
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {

		IncidentManagement inc = new IncidentManagement();
		inc.TC01CreateNewIncident();
		inc.TC002UpdateExistingIncident();
		inc.TC003Assign();
		inc.TC004DeleteIncident();
		inc.TC005Resove();
		inc.TC006IncidentwithoutMandatory();
	}

}
