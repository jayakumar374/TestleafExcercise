package Week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("Testcase Passed");
		} else {
			System.err.println("Testcase failed");
		}
		
		String test = driver.findElement(By.tagName("h2")).getText();
		System.out.println(test);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Aspire");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jayakumar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("Partner");
		WebElement drop1 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select s1 = new Select(drop1);
		s1.selectByVisibleText("Automobile");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Thiru");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("TK");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("04/15/21");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TEST AUTOMATION");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("JAVA");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("456");
		Select s2 = new Select(driver.findElement(By.id("createLeadForm_currencyUomId")));
		s2.selectByIndex(7);
		Select s3 = new Select(driver.findElement(By.id("createLeadForm_industryEnumId")));
		s3.selectByIndex(3);
		
		
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");
		Select s4 = new Select(driver.findElement(By.id("createLeadForm_ownershipEnumId")));
		s4.selectByIndex(3);
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("CS822");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("$Important notes");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("345");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("345");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("3");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Vanmathi");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vmathi@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://vamthi");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("jaya");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("jayakumar");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("TRY");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("AYPM");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Trichirapalli");
		Select s5 = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		s5.selectByIndex(3);
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("621005");
		Select s6 = new Select(driver.findElement(By.id("createLeadForm_generalCountryGeoId")));
		s6.selectByIndex(3);
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("7");
	
		
		driver.findElement(By.className("smallSubmit")).click();
		
		//To create duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		driver.findElement(By.className("smallSubmit")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Duplicate company name : " + text);
		String text2 = text.replaceAll("[^a-zA-Z]", "");
		System.out.println("Replaced company name : " + text2);
		if(text2.equals("Amazon"))
		{
			System.out.println("Company verified");
		}
		else
		{
			System.out.println("Company not verified");
		}
		driver.close();
		
	}

}
