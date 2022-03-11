package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase  {
	
	public HomePage(){
		
	PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[contains(text(),\"My Account\")]")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[contains(text(),\"Login\")]")
	WebElement Login;
	
	public void navigatetoLogin()
	{
		MyAccount.click();
		Login.click();
	}
	
	

}
