package hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import Steps.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PreandPost extends BaseTest {
	
	
	@Before
	public void launchbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}

	/*
	 * @AfterStep public void screenshot() throws IOException { File src =
	 * driver.getScreenshotAs(OutputType.FILE);
	 * 
	 * FileUtils.copyFile(src, new File("D:\\Roobini\\Training\\Scrennshots\\snap"
	 * +(i++) +".jpg")); }
	 */
	
}
