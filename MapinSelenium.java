package Assignment3;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapinSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("TPJ");
		fromStation.sendKeys(Keys.ENTER);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MS", Keys.ENTER);
		// toStation.sendKeys(Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(2000);
		Map<String, String> trainLIst = new HashMap<String, String>();

		List<WebElement> allTrains = driver
				.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		for(WebElement row : allTrains)
		{
			List<WebElement> column = row.findElements(By.tagName("td"));
			for(int i=0;i<column.size();i++)
			{
				if(column.get(i).getText().startsWith("S"))
				{
					trainLIst.put(column.get(i).getText(), column.get(i).getText());
				}
			}
		}
		System.out.println( trainLIst);
		driver.close();

	}

}
