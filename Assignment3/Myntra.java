package Assignment3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// To Launch browser
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		  ChromeOptions ch = new ChromeOptions();
		  ch.addArguments("--disable-notifications");
		 

		// To launch url
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// To click Women menu
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Women')]"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Jackets & Coats')]")).click();
		// TO find total count of item
		WebElement items = driver.findElement(By.xpath("//h1[@class='title-title']/following-sibling::span[1]"));
		String count = items.getText();
		String count1 = count.replaceAll("\\D", "");
		System.out.println(count1);
		int totaljacketcoats = Integer.parseInt(count1);
		// TO verify sum of count categories matches
		WebElement Jacketcount = driver.findElement(By.xpath("//label[text()='Jackets']"));
		String jacket = Jacketcount.getText();
		String totalJacket = jacket.replaceAll("\\D", "");
		System.out.println("Jacket count :" + totalJacket);
		int jack = Integer.parseInt(totalJacket);
		WebElement Coatscount = driver.findElement(By.xpath("//label[text()='Coats']"));
		String coats = Coatscount.getText();
		String totalCoat = coats.replaceAll("\\D", "");
		int coatsCt = Integer.parseInt(totalCoat);
		System.out.println("Coats count :" + totalCoat);

		if (totaljacketcoats == jack + coatsCt) {
			System.out.println("Category total cout are verified");

		} else {
			System.out.println("Total count mismatched");
		}
		// To check coats
		driver.findElement(By.xpath("(//span[@class='categories-num']/following-sibling::div)[2]")).click();
		// To click +more button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='brand-list']/following-sibling::div[1]")).click();
		// To type mango in textbox
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("MANGO");
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
		// TO close X pop up
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		// To verify all coats are brand of MANGO
		List<WebElement> AllBrands = driver.findElements(By.xpath("//h3[@class = 'product-brand']"));
		boolean mang = true;
		for (int i = 0; i < AllBrands.size(); i++) {
			String mango = AllBrands.get(i).getText();
			if (mango.equals("MANGO") == false) {
				mang = true;
				System.out.println("All coats brands are not MANGO");
				break;
			}

		}
		// TO clilk better discount
		driver.findElement(By.xpath("(//label[@class='common-customRadio vertical-filters-label'])[3]")).click();
		Thread.sleep(1000);
		// To get a price for first displayed item
		System.out.println("First displayed coat price :"
				+ driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText());
		//To mouse over on size of first item
		act.moveToElement(driver.findElement(By.xpath("//span[@class = 'product-discountedPrice']"))).perform();
		//To clik on whislist
		driver.findElement(By.xpath("//span[contains(@class,'product-wishlistFlex product-actionsButton')]//span")).click();
		Thread.sleep(1000);
		driver.close();

	}

}
