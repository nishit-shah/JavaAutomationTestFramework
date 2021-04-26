Feature: LoginFeature
This feature is responsible for testing all the scenarios for Login of application

Scenario: Check Login with correct username and password
Given I see application opened
When I click on Login Link
Then I enter Username and Password And I click on Login Button
|Username  | Password  |
|nishit123 | nishit123 |
Then I should see admin home page

