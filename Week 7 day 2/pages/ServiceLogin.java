package pages;

import org.openqa.selenium.By;


import hooks.TestNgHooks;

public class ServiceLogin extends TestNgHooks{
	
	public ServiceLogin switchFrame()
	{
		switchToFrame(locateElement("id", "gsft_main"));
		return this;
	}
	
	public ServiceLogin enterserviceUSername(String username)
	{
		append(locateElement("id", "user_name"),username);
		return this;
	}
	
	public ServiceLogin enterservicePassword(String password)
	{
		append(locateElement("id", "user_password"),password);
		return this;
	}
	
	public ServiceHome serviceclick(){
		click(locateElement("id", "sysverb_login"));
		
		return new ServiceHome();
	}
	

}
