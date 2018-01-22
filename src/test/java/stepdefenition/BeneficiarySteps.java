package stepdefenition;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import pages.AddNewBeneficiaryPage;
import pages.DashBoard;
import pages.LoginPage;
import pages.TransferFunds;

public class BeneficiarySteps {
	
	LoginPage lp;
	DashBoard db;
	TransferFunds tf;
	AddNewBeneficiaryPage bp;
	
	@Given("^I provide valid credentials$")
	public void i_provide_valid_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lp = new LoginPage();
		lp.enterUsername();
		lp.enterPassword();
	    
	}

	@Given("^click on login$")
	public void click_on_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lp.clickLoginButton();
	    
	}

	@When("^I am landed on dashboard$")
	public void i_am_landed_on_dashboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		db = new DashBoard();
		db.moveToPayments();
	    
	}

	@Then("^I click on Transfer Funds$")
	public void i_click_on_Transfer_Funds() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    db.clickTransferFunds();
	}

	@Then("^click on Add new payee$")
	public void click_on_Add_new_payee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		tf = new TransferFunds();
		tf.clickAddNewBeneficiary();
	    
	}
	
	@Then("^I enter valid beneficiary details on the page$")
	public void i_enter_valid_beneficiary_details_on_the_page(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		bp = new AddNewBeneficiaryPage();
		List<List<String>> data = arg1.raw();
		bp.enterPayeeName(data.get(0).get(1).toString());
		bp.enterPayeeNickName(data.get(1).get(1).toString());
		bp.enterAccountNo(data.get(2).get(1).toString());
		
	    
	}

	@Then("^I click on get Account details to verify name of the payee \"([^\"]*)\"$")
	public void i_click_on_get_Account_details_to_verify_name_of_the_payee(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		bp.clickGetAccountDetails();
		bp.verifyAccountName(arg1);
	    
	}
	
	@Then("^I enter valid beneficiary details on the page for Other Bank Account$")
	public void i_enter_valid_beneficiary_details_on_the_page_for_Other_Bank_Account(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		bp = new AddNewBeneficiaryPage();
		
		List<List<String>> data = arg1.raw();
		bp.enterPayeeName(data.get(0).get(1).toString());
		bp.enterPayeeNickName(data.get(1).get(1).toString());
		bp.selectDropdownAccountType(data.get(2).get(1).toString());
		bp.enterOtheBankAccountNo(data.get(3).get(1).toString());
		bp.enterConfirmAccNo(data.get(4).get(1).toString());
		bp.enterIFSCCode(data.get(5).get(1).toString());
		
	    
	}

	@Then("^I enter valid beneficiary details for Instant Money Transfer$")
	public void i_enter_valid_beneficiary_details_for_Instant_Money_Transfer(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		bp = new AddNewBeneficiaryPage();
		List<List<String>> data = arg1.raw();
		bp.enterPayeeName(data.get(0).get(1).toString());
		bp.enterPayeeNickName(data.get(1).get(1).toString());
		bp.selectDropdownAccountType(data.get(2).get(1).toString());
		bp.enterPayeeMobile(data.get(3).get(1).toString());
		bp.enterPayeeAddress(data.get(4).get(1).toString());
		bp.enterPayeePincode(data.get(5).get(1).toString());
	}


	
	@Then("^I click on proceed to submit the details$")
	public void i_click_on_proceed_to_submit_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //bp.clickProceed();
	}

	

}
