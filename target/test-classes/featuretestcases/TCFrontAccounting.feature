Feature: Login

@valid @smoke @testcase_login_001
Scenario: Verify the functionality of login by valid data
Given User has launched the Chrome Browser
And User has opened Front Accounting website
When User has cleared data and entered "demouser" in username field
And User has cleared data and entered "password" in password field
And User has clicked on Login button
Then Validate login functionality by title of the page
And User has closed the browser

@invalid @regression @testcase_login_002
Scenario: Verify the functionality of login by invalid data
Given User has launched the Chrome Browser
And User has opened Front Accounting website
When User has cleared data and entered "userdemo" in username field
And User has cleared data and entered "password" in password field
And User has clicked on Login button
Then Validate login functionality by title of the page
And User has closed the browser
