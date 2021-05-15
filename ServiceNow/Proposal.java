package ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proposal {

	public void TC001NewProposal() throws InterruptedException {
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// To Login the application
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("Proposal", Keys.ENTER);
		Thread.sleep(1500);
		// TO CLick new
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_new")).click();
		// Mandatory fields entry
		/*
		 * driver.findElement(By.xpath(
		 * "(//button[@name='lookup.std_change_proposal.assignment_group']//span[1]")).
		 * click(); Set<String> windowHandles = driver.getWindowHandles(); List<String>
		 * ChildWindow = new ArrayList<String>(windowHandles);
		 * driver.switchTo().window(ChildWindow.get(1));
		 */
		Thread.sleep(1000);
		// driver.findElement(By.linkText("Software")).click();
		// driver.switchTo().window(ChildWindow.get(0));
		WebElement proposal = driver.findElement(By.id("std_change_proposal.number"));
		String ProposalNo = proposal.getAttribute("value");
		System.out.println(ProposalNo);
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Template Desc");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(1000);
		// TO click MY proposal
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		driver.switchTo().frame("gsft_main");
		// driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ProposalNo, Keys.ENTER);
		WebElement ProposalSearch = driver
				.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody[1]/tr[1]/td[3]/a[1]"));
		if (ProposalSearch.getText().equals(ProposalNo)) {
			System.out.println("Proposal number :" + ProposalSearch.getText() + "  Created");
		} else {
			System.out.println("Proposal number not created");
		}
		driver.close();

	}

	public void TC002ChangeProposal() throws InterruptedException {
		String ProposalNo = "STDCHG0001211";
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://dev103117.service-now.com/navpage.do");
		// To Login the application
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("Proposal", Keys.ENTER);
		Thread.sleep(1500);
		// TO CLick new
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		search.click();
		search.sendKeys(ProposalNo, Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		// Mandatory fields entry
		driver.findElement(By.id("lookup.std_change_proposal.assignment_group")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ChildWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow.get(1));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(ChildWindow.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.std_change_proposal.category")).click();
		windowHandles = driver.getWindowHandles();
		List<String> ChildWindow2 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow2.get(1));
		driver.findElement(By.linkText("Template Management")).click();
		driver.switchTo().window(ChildWindow2.get(0));
		driver.switchTo().frame("gsft_main");
		Select state = new Select(driver.findElement(By.id("std_change_proposal.state")));
		state.selectByIndex(1);
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'icon-search btn')]")).click();
		windowHandles = driver.getWindowHandles();
		List<String> ChildWindow1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ChildWindow1.get(1));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Hardware")).click();
		driver.switchTo().window(ChildWindow1.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//td[@data-value='Justification']//textarea[1]")).sendKeys("JUSTIFICATION");
		driver.findElement(By.xpath("//td[@data-value='Risk and impact analysis']//textarea[1]"))
				.sendKeys("Risk Analysis");
		driver.findElement(By.id("sysverb_update_bottom")).click();

		WebElement upsearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		upsearch.click();
		upsearch.sendKeys(ProposalNo, Keys.ENTER);
		WebElement ProposalSearch = driver
				.findElement(By.xpath("//table[@id='std_change_proposal_table']/tbody[1]/tr[1]/td[6]"));
		if (ProposalSearch.getText().equals(ProposalNo)) {
			System.out.println("Proposal number :" + ProposalSearch.getText() + "  Updated");
		} else {
			System.out.println("Proposal number not Updated");
		}
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		Proposal proposal = new Proposal();
		// proposal.TC001NewProposal();
		proposal.TC002ChangeProposal();

	}

}
