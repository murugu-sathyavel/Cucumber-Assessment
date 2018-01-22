package stepdefenition;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import pages.DashBoard;
import pages.LoginPage;
import pages.TransferFunds;

public class TransferFundsSteps {
	
	LoginPage lp;
	DashBoard db;
	TransferFunds tf;
	
	@Given("^I login with valid credentials$")
	public void i_login_with_valid_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lp = new LoginPage();
		lp.enterUsername();
		lp.enterPassword();
		lp.clickLoginButton();
	    
	}

	@When("^I navigate to dashboard$")
	public void i_navigate_to_dashboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    db = new DashBoard();
	    db.moveToPayments();
	    
	}

	@Then("^I click on TransferFunds to verify my beneficiarys$")
	public void i_click_on_TransferFunds_to_verify_my_beneficiarys(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		db.clickTransferFunds();
		List<String> payeeList = arg1.asList(String.class);
		tf = new TransferFunds();
		tf.compareBeneficiarys(payeeList);
	    
	}

}
