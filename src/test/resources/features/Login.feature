Feature: Login Feature
As a Valid customer 
I am login into Axis net banking to access my account

Scenario: Login with valid credentials
	Given I have valid credentials
	When I enter my username and password
	And clicking on login button
	Then I should successfuly login into my Account to check my balance "19.73"