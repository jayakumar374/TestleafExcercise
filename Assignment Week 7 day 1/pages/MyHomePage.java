package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;



public class MyHomePage extends TestNgHooks {
	
	public MYLEadPage clickLeadMenu()
	{
		click(locateElement("link", "Leads"));
		driver.findElement(By.linkText("Leads")).click();
		return new MYLEadPage();
	}


}
