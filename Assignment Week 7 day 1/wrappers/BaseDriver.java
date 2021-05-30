package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> allWindows = new ArrayList<>(windowHandles);
			String windowHandle = allWindows.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The window of index "+index+" switched");
		} catch (Exception e) {
			System.err.println("The window of index "+index+" could not be switched");
		}
		

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+data);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+data);
		}

	}
	
	@Override
	public void typeAndEnter(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data, Keys.ENTER);
			System.out.println("The element "+ele+" is typed and entered with the value "+ele);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed / entered with the value "+ele);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("The element is matched with text "+expectedText);
		} else {
			System.err.println("The element did not match with text "+expectedText);
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)) {
			System.out.println("The element contains with text "+expectedText);
		} else {
			System.err.println("The element did not contains the text "+expectedText);
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			if(driver.getTitle().contains(expectedTitle))
			{
				System.out.println("Title is verified");
			}
		} catch (Exception e) {
		System.err.println("Title invalid");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		try {
			driver.close();
			System.out.println("The browser is closed");
		} catch (Exception e) {
			System.err.println("The browser is already closed, check where it got closed");
		}
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}





}
