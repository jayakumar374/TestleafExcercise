package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import hooks.TestNgHooks;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class ServiceMyRequest extends TestNgHooks {

	
	public ServiceMyRequest clickSearchandTypeReq(String reqID) {
		click(locateElement("xpath", "//input[@placeholder='Search']"));
		append(locateElement("xpath", "//input[@placeholder='Search']"), reqID);
		getDriver().findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		return this;

	}

	public ServiceMyRequest clickdisplayedReq() throws InterruptedException {
		click(locateElement("xpath","//table[@id='sc_request_table']/tbody[1]/tr[1]/td[3]/a[1]"));
		return this;
	
	}

	

	
	public ServiceMyRequest updateApproval() throws InterruptedException {
		selectDropDownUsingValue(locateElement("id", "sc_request.approval"), "requested");
		return this;
		
	}

	public ServiceMyRequest updateReq() {
		selectDropDownUsingText(locateElement("id", "sc_request.request_state"), "Approved");
		return this;
		
	}

	
	public ServiceMyRequest updateOther(String text) {
		click(locateElement("xpath","(//span[@class='icon icon-search'])[2]"));
		
		switchToWindow(1);
				click(locateElement("link", "Apac"));
		switchToWindow(0);
		switchToFrame("gsft_main");
		append(locateElement("id", "sc_request.description"), text);
		return this;
		
	}


	public ServiceMyRequest updateRequest() {
		click(locateElement("id","sysverb_update_bottom"));
		return this;
	}


	public ServiceMyRequest clickRejected() {
		selectDropDownUsingValue(locateElement("id","sc_request.approval"), "rejected");
		return this;
		
	}

	
	public ServiceMyRequest clickCanceled() {
	selectDropDownUsingText(locateElement("id","sc_request.request_state"), "Closed Cancelled");
	return this;
		
	}

	
	public ServiceMyRequest toSelectCancelReq() {
		click(locateElement("xpath", "(//button[text()='Cancel Request'])[2]"));
		return this;
	}
}
