package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import hooks.TestNgHooks;
import io.cucumber.java.en.Given;

public class Login extends TestNgHooks{
		
	
	public Login typeUserName(String userdata) {
		type(locateElement("id", "username"), userdata);
		return this;
	}
	
	
	public Login typePassword(String passdata) {
		type(locateElement("id", "password"), passdata);
		return this;
	}
	
	public Home typePasswordAndEnter(String passdata) {
		typeAndEnter(locateElement("id", "password"),passdata);
		return new Home();
	}
	
	@Given("Click Login")
	public Home clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		return new Home();
	}
	
	public Login clickLoginForFailure() {
		click(locateElement("class", "decorativeSubmit"));
		return this;
	}

	public Object typeUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
