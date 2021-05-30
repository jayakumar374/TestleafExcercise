package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;



public class CreateLeadPage extends TestNgHooks {

	public CreateLeadPage typeCompanyName(String company)
	{
		type(locateElement("id", "createLeadForm_companyName"), company);
		
		return this;
	}
	
	public CreateLeadPage typeFirstName(String fname){
		type(locateElement("id", "createLeadForm_firstNam"), fname);
		return this;
		
	}
	
	public CreateLeadPage typeLastName(String lname)
	{
		type(locateElement("id", "createLeadForm_lastName"), lname);
		
		return this;
	}
	
	public ViewLead ClikCreateleadButton()
	{
		click(locateElement("class", "smallSubmit"));
		return new ViewLead();
	}
}
