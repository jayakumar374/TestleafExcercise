package Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
                 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://erail.in/");
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("TPJ");
		fromStation.sendKeys(Keys.ENTER);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MS");
		toStation.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> allTrains = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]"));
		List<String> trains = new ArrayList<String>();
		for(int i=0;i<allTrains.size();i++)
		{
			//System.out.println(allTrains.get(i).getText());
			
			trains.add(allTrains.get(i).getText());
			
			
		}
		Collections.sort(trains);
		System.out.println(trains);
		//System.out.println("Total trains are  " + allTrains.size());
		driver.close();
		
	}

}
