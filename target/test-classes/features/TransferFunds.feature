Feature: Transfer Funds Feature
As a Valid customer 
I am login into Axis net banking to access my account

Scenario: Verify my Beneficiary details
	Given I login with valid credentials
	When I navigate to dashboard
	Then I click on TransferFunds to verify my beneficiarys 
	|Sathish Muthukumaran|
	|Karthik Pollachi|
	|Antony|
	|Deva Kanth|
	|Rajesh Sas|
	|Alagu|
	|Nitish|
	|Rajesh Vit|
	|Siva Elite|
	|Palani|