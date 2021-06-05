package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hooks.TestNgHooks;


public class ServiceMobile extends TestNgHooks{

	boolean ReqVerify;
	
	public ServiceMobile clickIPhone() throws InterruptedException
	{
		
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(1000);
				click(locateElement("xpath", "//strong[text()='Apple iPhone 6s']"));
				return this;		
	}
	
	
	public ServiceMobile selectAllowence()
	{
		selectDropDownUsingValue(locateElement("xpath", "//select[@class='form-control cat_item_option ']"),"unlimited");
		return this;
					
	}
		
	
	public ServiceMobile selectColor() throws InterruptedException
	{
		selectDropDownUsingText(locateElement("xpath","(//select[@class='form-control cat_item_option '])[2]"), "Rose Gold");
		return this;
		
	}
	
	
	public ServiceMobile selectStorage() throws InterruptedException
	{
		selectDropDownUsingIndex(locateElement("xpath", "(//select[@class='form-control cat_item_option '])[3]"), 2);
		return this;
	}
	
	
		public ServiceMobile clickOrdernow()
		{
			click(locateElement("id", "oi_order_now_button"));
			return this;
		}
	
	
	public void verifyOrder()
	{
		WebElement Reqno = getDriver().findElement(By.xpath("//a[@id='requesturl']//b[1]"));
		System.out.println("Request Number " + Reqno.getText());
		boolean ReqVerify = false;
		if (!Reqno.getText().isEmpty()) {
			ReqVerify = true;
			System.out.println("Order " + Reqno.getText() + " Generated");
		} else {
			System.out.println("Order not generated");
		}
	
	}
	
}
