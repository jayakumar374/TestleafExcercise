package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;

public class MYLEadPage extends TestNgHooks {
	public CreateLeadPage createLead()
	{
		click(locateElement("link", "Create Lead"));
		
		return new CreateLeadPage();
	}
}
