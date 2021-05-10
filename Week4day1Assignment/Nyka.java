package Week4day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nyka {

	public static void main(String[] args) throws InterruptedException {
		// To launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// To launch Website
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// To mouseover on brands and popular
		WebElement brands = driver.findElement(By.xpath("//a[contains(text(),'brands')]"));
		Actions act = new Actions(driver);
		act.moveToElement(brands).perform();
		Thread.sleep(2000);
		WebElement popular = driver.findElement(By.xpath("//div[@class = 'BrandsCategoryHeading']/a"));
		act.moveToElement(popular).perform();
		// Click loreal Paris
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']/ul[1]/li[5]/a[1]/img[1]")).click();
		// TO verify title as Loreal Paris and switch to child window
		System.out.println(driver.getTitle());
		Set<String> ParentWindow = driver.getWindowHandles();
		List<String> lt = new ArrayList<String>(ParentWindow);
		driver.switchTo().window(lt.get(1));
		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("Title Verified");
		} else {
			System.out.println("Tile not verified");
		}
		// To click sort by and select customer top rated
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//input[@id='3']/following-sibling::div[1]")).click();
		// To click sampoo from category -->category>hair>hair style>sampoo
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Category')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='control__indicator']/parent::label")).click();
		Thread.sleep(2000);
		// To verify shampoo is filtered

		// System.out.println(driver.fing);
		if (driver.findElement(By.xpath("//li[text()='Shampoo']")).getText().contains("Shampoo")) {
			System.out.println("Shampoo filtered");
		} else {
			System.out.println("Shampoo not filtered");
		}

		// To click loreal paris shampoo
		// JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//span[contains(text(),'Colour Protect')][1]")).click();
		Thread.sleep(2000);
		// Switching new window and select 175 ML
		ParentWindow = driver.getWindowHandles();
		List<String> second = new ArrayList<String>(ParentWindow);
		driver.switchTo().window(second.get(2));
		// To print price
		System.out.println("Price are :"
				+ driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText());
		// To click add to bag
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		Thread.sleep(1000);
		// To Click Shopping bag
		driver.findElement(By.xpath("//div[@class='cursor-hand arrowup-tooltip']/following-sibling::div[1]")).click();
		Thread.sleep(1000);
		// To Print Grant total
		WebElement GrantTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div"));
		String gTotal = GrantTotal.getText();
		System.out.println("Grant Total :" + GrantTotal.getText());
		// To CLick Proceed button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click();
		Thread.sleep(1000);
		// TO click continue as guest
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//To Verify Grand total

		WebElement guestTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]"));
		if (gTotal.equals(guestTotal.getText())) {
			System.out.println("Grant total is verified successfully");
		} else {
			System.out.println("Grant total is invalid");
		}
driver.close();
driver.switchTo().window(second.get(1));
driver.close();
driver.switchTo().window(lt.get(0));
driver.close();

	}

}
