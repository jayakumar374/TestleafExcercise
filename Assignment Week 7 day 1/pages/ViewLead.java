package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;



public class ViewLead extends TestNgHooks {
	
	public ViewLead VerifyLead()
	{
		verifyPartialTitle("View Lead");
		
		
		return this;
	}

}
