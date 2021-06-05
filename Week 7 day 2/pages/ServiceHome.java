package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import hooks.TestNgHooks;

public class ServiceHome extends TestNgHooks {
	public ServiceHome clickFilter(String filter) {

		append(locateElement("id", "filter"), filter);
		return this;
	}

	public ServiceHome clickCatalog() {
		click(locateElement("xpath", "//div[text()='Catalog']"));

		return this;
	}

	/*public ServiceHome switchFrame() {
		switchToFrame(locateElement("id", "gsft_main"));
		return this;
	}*/

	public ServiceMobile clickMobileandswitchFrame() throws InterruptedException {
		getDriver().switchTo().frame("gsft_main");
		
		click(locateElement("xpath", "//h2[text()[normalize-space()='Mobiles']]"));
		setWait();
		return new ServiceMobile();
	}

	public ServiceMyRequest ClickMyreq() throws InterruptedException {
		click(locateElement("xpath", "//div[text()='Requests']"));
		getDriver().switchTo().frame("gsft_main");
		
		return new ServiceMyRequest();

	}
}
