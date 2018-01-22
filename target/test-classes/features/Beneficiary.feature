Feature: Manage Beneficiary Feature
As a Valid customer 
I am login to manage beneficiary effectively to do my transactions

Background: 
	Given I provide valid credentials
	And click on login
		

Scenario: Adding Benficiary of our own bank
	When I am landed on dashboard
	Then I click on Transfer Funds
	And click on Add new payee
	Then I enter valid beneficiary details on the page
	|payeeName|Sathiya|
	|payeeNickName|sathya|
	|AccountNumber|910010041251213|
	And I click on get Account details to verify name of the payee "Sathiya Moorthy M"
	Then I click on proceed to submit the details
	
	
Scenario: Adding Benficiary of other Bank Account
	When I am landed on dashboard
	Then I click on Transfer Funds
	And click on Add new payee
	Then I enter valid beneficiary details on the page for Other Bank Account
	|payeeName|Sathiya|
	|payeeNickName|sathya|
	|AccountType|Other Bank Accounts|
	|AccountNumber|1100123456789|
	|confirmAccount|1100123456789|
	|Ifsccode|SBI001236547|
	Then I click on proceed to submit the details
	
Scenario: Adding Benficiary for Instant Money Tansfer
	When I am landed on dashboard
	Then I click on Transfer Funds
	And click on Add new payee
	Then I enter valid beneficiary details for Instant Money Transfer
	|payeeName|Sathiya|
	|payeeNickName|sathya|
	|AccountType|Instant Money Transfer|
	|mobil|9894449505|
	|address|chennai|
	|pincode|600041|
	Then I click on proceed to submit the details