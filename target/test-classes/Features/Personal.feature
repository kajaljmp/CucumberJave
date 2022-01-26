Feature: Test Borrowing estimate

Scenario: Personal Details fillup
		Given User navigates to home page "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
		When user enters Specific Your Application Type and type of property
		When User enters number of dependants as 0
		When Income "80000" and other income "10000" and Living Expenses "500" and Home loan repayment "0" and other loan repayment "100" and other commitment "0" and credit card limit "10000"
		And clicks on Borrow
		Then Gets Estimate

Scenario: Message return with $1 income
	Given User navigates to home page "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
	When user enters Specific Your Application Type and type of property
	When User enters number of dependants as 0
	When Income "0" and other income "0" and Living Expenses "1" and Home loan repayment "0" and other loan repayment "0" and other commitment "0" and credit card limit "0"
	And clicks on Borrow
	Then Return error message
