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

public class ServiceCategory {

	public void TC001OrderingMobile() throws InterruptedException {
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
		// 3. Enter Service catalog in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Service catalog", Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Catalog']")).click();
		// 4. Click on mobiles
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
		Thread.sleep(1000);
		// 5.Select Apple iphone6s
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		// 6.Update Monthly allowances field to Unlimited ,color field to rose gold and
		// storage field to 128GB
		Select Allowence = new Select(driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")));
		Allowence.selectByValue("unlimited");
		Select color = new Select(
				driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")));
		color.selectByVisibleText("Rose Gold");
		Select storage = new Select(
				driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]")));
		storage.selectByIndex(2);
		// 7.Select Order now option
		driver.findElement(By.id("oi_order_now_button")).click();
		// 8.Verify order is placed and copy the request number
//WebElement VerifyOrder = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']"));
		WebElement Reqno = driver.findElement(By.xpath("//a[@id='requesturl']//b[1]"));
		System.out.println("Request Number " + Reqno.getText());
		boolean ReqVerify = false;
		if (!Reqno.getText().isEmpty()) {
			ReqVerify = true;
			System.out.println("Order " + Reqno.getText() + " Generated");
		} else {
			System.out.println("Order not generated");
		}
		driver.close();
	}

	public void TC002Update() throws InterruptedException {
		String ReqNumber = "REQ0010145";
		// 1. Launch ServiceNow application
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// 2. Login with valid credentials username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		// 3. Enter Service catalog in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Service catalog", Keys.ENTER);
		// 4.Select MyRequest and paste the copied request number in request and search
		driver.findElement(By.xpath("//div[text()='Requests']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ReqNumber, Keys.ENTER);
		// 5.Select the shown request number
		driver.findElement(By.xpath("//table[@id='sc_request_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		// 6.Update Approval field to Requested and Request State Field to Approved
		Select Approval = new Select(driver.findElement(By.id("sc_request.approval")));
		Approval.selectByValue("requested");
		Select request = new Select(driver.findElement(By.id("sc_request.request_state")));
		request.selectByVisibleText("Approved");
		// 7.Update the remaining fields available
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ChildWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow.get(1));
		driver.findElement(By.linkText("Apac")).click();
		driver.switchTo().window(ChildWindow.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sc_request.description")).sendKeys("Mobile Ordered");
		// 8.Update request
		driver.findElement(By.id("sysverb_update_bottom")).click();

		driver.close();
	}

	public void TC003CancelOrder() throws InterruptedException {
		String ReqNumber = "REQ0010051";
		// 1. Launch ServiceNow application
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// 2. Login with valid credentials username as admin and password as India@123
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		// 3. Enter Service catalog in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Service catalog", Keys.ENTER);
		// 4.Select MyRequest and paste the copied request number in request and search
		driver.findElement(By.xpath("//div[text()='Requests']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ReqNumber, Keys.ENTER);
		// 5.Select the shown request number
		driver.findElement(By.xpath("//table[@id='sc_request_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		Thread.sleep(1000);
		// 6.Update Approval field to Rejected and Request State Field to closed
		// cancelled
		Select Approval = new Select(driver.findElement(By.id("sc_request.approval")));
		Approval.selectByValue("rejected");
		Select request = new Select(driver.findElement(By.id("sc_request.request_state")));
		request.selectByVisibleText("Closed Cancelled");
		// 7.Select Cancel request option
		driver.findElement(By.xpath("(//button[text()='Cancel Request'])[2]")).click();
		driver.close();

	}

	public void TC004DeleteOrder() throws InterruptedException {
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
		// 3. Enter Service catalog in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Service catalog", Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Catalog']")).click();
		// 4. Click on mobiles
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
		Thread.sleep(1000);
		// 5.Select Apple iphone6s
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		// 6.Update Monthly allowances field to Unlimited ,color field to rose gold and
		// storage field to 128GB
		Select Allowence = new Select(driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")));
		Allowence.selectByValue("unlimited");
		Select color = new Select(
				driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")));
		color.selectByVisibleText("Rose Gold");
		Select storage = new Select(
				driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]")));
		storage.selectByIndex(2);
		// 7.Select Order now option
		driver.findElement(By.id("oi_order_now_button")).click();
		// 8.Verify order is placed and copy the request number
		// WebElement VerifyOrder = driver.findElement(By.xpath("//span[text()='Thank
		// you, your request has been submitted']"));
		WebElement Reqno = driver.findElement(By.xpath("//a[@id='requesturl']//b[1]"));
		String ReqNumber = Reqno.getText();
		System.out.println("Order " + ReqNumber + " Created");
		// 9.Select the shown request number
		driver.findElement(By.xpath("//a[@id='requesturl']//b[1]")).click();
		// 10. Delete the order
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		driver.findElement(By.id("ok_button")).click();
		// 11.Verify whether the order is deleted
		WebElement VerifyDelete = driver.findElement(By.xpath("//div[@class='notification notification-warning']"));
		System.out.println(VerifyDelete.getText());
		if (VerifyDelete.getText().contains("Order:Empty") &&  VerifyDelete.getText().contains("Close")) {
			System.out.println("Order " + ReqNumber + " Deleted");
		} else {
			System.out.println("Order existing");
		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		ServiceCategory service = new ServiceCategory();
		// service.TC001OrderingMobile();
		// service.TC002Update();
		//service.TC003CancelOrder();
		service.TC004DeleteOrder();

	}

}
