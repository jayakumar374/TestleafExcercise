package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;
import pages.ServiceLogin;

public class MobileOrder extends TestNgHooks {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Ordering mobile on servicenow application";
		testDescription = "Ordering Apple IPhone using service now application with different configuration";
		nodes = "Accounts";
		authors = "Jayakumar";
		category = "Functional";
		dataSheetName = "MobileOrder";
	}

	@Test(dataProvider = "fetchData")
	public void mobileOrder(String username, String password,String filter) throws InterruptedException {
		new ServiceLogin().switchFrame().enterserviceUSername(username)
		.enterservicePassword(password).serviceclick()
		.clickFilter(filter).clickCatalog().clickMobileandswitchFrame().clickIPhone()
		.selectAllowence().selectColor().selectStorage().clickOrdernow().verifyOrder();
	}

}
