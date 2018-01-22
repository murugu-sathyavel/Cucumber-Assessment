package stepdefenition;

import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.*;
import pages.DashBoard;
import pages.LoginPage;

public class LoginSteps{
	
	LoginPage lp;
	RemoteWebDriver driver;
	DashBoard db;
	
	@Given("^I have valid credentials$")
	public void i_have_valid_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Given one");
	    lp = new LoginPage();
	}

	@When("^I enter my username and password$")
	public void i_enter_my_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When one");
		lp.enterUsername();
		lp.enterPassword();
		
	}

	@When("^clicking on login button$")
	public void clicking_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("When two");
		lp.clickLoginButton();
	}

	@Then("^I should successfuly login into my Account to check my balance \"([^\"]*)\"$")
	public void i_should_successfuly_login_into_my_Account_to_check_my_balance(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Then One");
		db = new DashBoard();
		db.verifyBalanceInDashBoard(arg1);
		
	}


}
