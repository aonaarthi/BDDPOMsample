package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
public class myAccount extends TestBase {

	@FindBy(css="input.form-control.input-lg")
	WebElement searchbox;
	
	@FindBy(css="span.input-group-btn")
	WebElement searchbtn;
	
	public myAccount() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void search(String ser) {
		
		
		searchbox.sendKeys(ser);
		searchbtn.click();
		
	}
	
	public String returntitle()
	{
		return driver.getTitle();
	}
	

}
