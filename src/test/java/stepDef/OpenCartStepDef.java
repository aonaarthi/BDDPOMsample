package stepDef;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class OpenCartStepDef extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	myAccount accpage;
	SearchResultsTest searchpage;
	
//	public OpenCartStepDef() throws IOException {
//		super();
//		// TODO Auto-generated constructor stub
//		
//		
//		loginpage= new LoginPage();
//		searchpage =new SearchResultsTest();
//	}
	@Before
	public void setup() throws Exception
	{
		homepage =new HomePage();
		loginpage= new LoginPage();
		searchpage =new SearchResultsTest();
	}
	@Given("User is on opencart home page")
	public void user_is_on_opencart_home_page() {
	   
		initialize();
		
	}
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws IOException {
	    
		homepage =new HomePage();
		homepage.navigatetoLogin();
		Assert.assertEquals(driver.getTitle(), "Account Login");
		
	    
	}
	@Given("User logins with {string} and {string}")
	public void user_logins_with_and(String struser, String strpwd)  {
		

		loginpage= new LoginPage();
		
		accpage= loginpage.login(struser, strpwd);
			 	}
	
	@Then("User navigate to Account page")
	public void user_navigate_to_account_page() {
	    String title= accpage.returntitle();
	    Assert.assertEquals(title, "My Account");
	}
	
	@Given("User navigate to My Account page")
	public void user_navigate_to_my_account_page() {
		accpage =new myAccount();
		String title= accpage.returntitle();
	    Assert.assertEquals(title, "My Account");
	    
	}
	@When("User search item")
	public void user_search_item(io.cucumber.datatable.DataTable dataTable) {
		
		List<List<String>> items= dataTable.asLists();
		String item = items.get(0).get(0);
		accpage.search(item);
		
	    
	}
//	@Then("User navigate to searh result page")
//	public void user_navigate_to_searh_result_page() throws IOException {
//		
//		
//		
//		boolean result = searchpage.isResultDisplayed();
//		Assert.assertTrue(result);
//	    
//	}

	//User navigate to search result page
	@Given("User navigate to search result page")
	public void user_navigate_to_search_result_page() {
		
		boolean result = searchpage.isResultDisplayed();
		Assert.assertTrue(result);
		
	}
	@When("User Add item to Cart")
	public void user_add_item_to_cart() {
		
		searchpage.additemtoCart();
	    
	}
	@Then("Item must be avalable in the cart")
	public void item_must_be_avalable_in_the_cart() {
	    
		boolean flag = searchpage.isItemadded();
		Assert.assertTrue(flag);
	   
		
	}
	
//	@AfterAll
//	public void teardown()
//	{
//		driver.quit();
//	}
//
//



}
