package aussie.com.au;

import CommonUtils.WebIntegration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MeetOurBroker {
	
	WebIntegration WebI=new WebIntegration();
	
	@Given("^I visit \"([^\"]*)\" website on \"([^\"]*)\"$")
	public void Open_browser_and_URL(String url,String browser)
	{
		WebI.OpenBrowser(browser);
		WebI.GetURL(url);
System.out.println("testtttt");		
	}
	@And("^I view \"([^\"]*)\" menu and wait for \"([^\"]*)\"$")
	public void i_view_menu(String menuName,String submenu) {
		WebI.ClickElement(menuName);
		//WebI.WaitUntilElementVisible(submenu);
	    	}

	@When("^I select \"([^\"]*)\" menu$")
	public void i_select_menu(String submenu) throws InterruptedException  {
		WebI.ClickElement(submenu);
	}



	@When("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String link) throws InterruptedException  {
	   		WebI.ClickElement(link);
	}


	@Then("^should be navigated to \"([^\"]*)\" screen$")
	public void should_be_navigated_to_screen(String screen){
	    
	}

	@And("^enter the following values \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_the_firstname(String firstname, String fname)  {
	    WebI.SendKeys(firstname,fname);
	 }
	
	@And("^lastname \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_the_lastname(String lastname, String lname)  {
	 
	    WebI.SendKeys(lastname, lname);
	 }
	
	@And("^email \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_the_email(String email, String emailValue)  {
	    WebI.SendKeys(email, emailValue);
	 }
	
	@And("^phone \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_the_phone(String phone, String phoneValue)  {
	    WebI.SendKeys(phone, phoneValue);
	 
	}
	@And("^suburb \"([^\"]*)\" as \"([^\"]*)\"$")
	public void enter_the_suburb(String suburb, String suburbValue)  {
	    WebI.SendKeys(suburb, suburbValue);
	    WebI.KeyDown();
	}
	@And("^click on \"([^\"]*)\" button$")
	public void bookappoint(String locator)  {
		WebI.ClickElementUsingID(locator);
	}
		

	@Then("^following message \"([^\"]*)\" is displayed in \"([^\"]*)\"$")
	public void following_message_is_displayed(String message,String locator){
		WebI.GetText(locator, message);
	WebI.CloseBrowser();
	    
	}


}
