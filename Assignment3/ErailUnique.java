package Assignment3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
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
		List<WebElement> allTrains = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]"));
		List<String> trainName = new ArrayList<String>();
		for (int i = 0; i < allTrains.size(); i++) {
			trainName.add(allTrains.get(i).getText());

			Set<String> t = new HashSet<String>();
			System.out.println(t.add(allTrains.get(i).getText()));
			
		}
		
		System.out.print(trainName);
		Set<Integer> trainSize = new HashSet<Integer>();
		for(int i=0;i<trainName.size();i++)
		{
			trainSize.add(i);
		}
		System.out.print("Total trains are  " + trainSize.size());

		driver.close();

	}

}
