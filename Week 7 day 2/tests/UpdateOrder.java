package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;
import pages.ServiceLogin;

public class UpdateOrder extends TestNgHooks {
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update an exisitng order in servicenow application";
		testDescription = "Update an existing order using service now application with different configuration";
		nodes = "Accounts";
		authors = "Jayakumar";
		category = "Functional";
		dataSheetName = "UpdateOrder";
	}

	@Test(dataProvider = "fetchData")
	public void updateOrder(String username, String password,String filter,String reqID, String text) throws InterruptedException {
		new ServiceLogin().switchFrame().enterserviceUSername(username)
		.enterservicePassword(password).serviceclick()
		.clickFilter(filter).ClickMyreq()
		.clickSearchandTypeReq(reqID).clickdisplayedReq()
		.updateApproval().updateReq().updateOther(text)
		.updateRequest();
		
		;
	}

}
