@LoginTest
Feature: All Login Scenarios


@RegressionTest
Scenario: Login With Blank credentials
Given User is on the Login page
When User is trying to login with blank credentials using "" and ""
Then Error message displays as "Required" under username and password textboxes

@SanityTest
Scenario Outline: Login with Invalid credentials
Given User is on the Login page
When User is trying to login with invalid credentials using "<userName>" and "<password>"
Then Error message displays as "Invalid credentials"

Examples:

|userName|password|
|Admin	 |aaa			|
|aaa		 |admin123|
|bbb		 |abababa	|


@ValidLoginTest @SmokeTest
Scenario: Login with Valid Credentials
Given User is on the Login page
When User is trying to login with valid credentials using "username" and "password"
Then User gets login successfully on "Dashboard" page
      
