package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class TC_CreateACC extends TestNgHooks{

	@BeforeTest
	public void setValues() {
		testCaseName = "Create Account";
		testDescription = "Create account with valid details";
		nodes = "Accounts";
		authors = "Jayakumar";
		category = "Functional";
		dataSheetName = "ACC";
	}

	@Test(dataProvider = "fetchData")
	public void createAccount(String uName, String pwd,String accname) {
		new LoginPage().enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickAccounts()
		.clickCreateAcc().entrAccName(accname).clickCreateACccButton1()
		.verifyAccDetails();
		
	}

}
