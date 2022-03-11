package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchResultsTest extends TestBase {

	@FindBy(xpath = "//h1[contains(text(),'Search')]")
	WebElement searchheading;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	WebElement AddtoCart;
	
	@FindBy(id="cart-total")
	WebElement totalcart;
	
	@FindBy(css="div.product-thumb")
	List <WebElement> items;
	
	public SearchResultsTest() throws IOException {
		
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
	public void additemtoCart()
	{
		AddtoCart.click();
	}
	
	public boolean isItemadded()
	{
		
		String total = totalcart.getText();
		System.out.println(total);
		String itemcount =total.split(" ")[0];
		int item = Integer.parseInt(itemcount);
		
		if (item>0) 
		 return true;
		else
		return false;
		
	}
	
	public boolean isResultDisplayed()
	{
		return (searchheading.isDisplayed());
		
		
	}
	
	
	
	
	

}
