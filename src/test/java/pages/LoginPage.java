package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	

	@FindBy(name="email")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(css="input.btn.btn-primary")
	WebElement loginBtn;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotpwd;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	//login
	
	public myAccount login(String struser,String strpwd)
	{
		uname.sendKeys(struser);
		pwd.sendKeys(strpwd);
		loginBtn.click();
		return new myAccount();
	}
	
}
