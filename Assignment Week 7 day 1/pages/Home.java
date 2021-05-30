package pages;

import org.openqa.selenium.By;


import hooks.TestNgHooks;
import io.cucumber.java.en.Given;


public class Home extends TestNgHooks{
	
	
	public Home verifyWelcomeMessage() {
		verifyPartialText(locateElement("tag", "h2"), "Welcome");
		return this;
	}
	
	
	public Login clickLogout() {
		click(locateElement("class", "decorativeSubmit"));
		return new Login();
	}
	public MyHomePage clickCRMSFA()
	{
		click(locateElement("link", "CRM/SFA"));
		
		return new MyHomePage();
	}
	

}
