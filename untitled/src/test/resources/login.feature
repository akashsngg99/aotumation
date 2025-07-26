Feature: User Login to IIEST Campus Portal
  As a user, I want to log in to the IIEST Campus Portal
  So that I can access my academic information

  Scenario: Successful Login with Valid Credentials
    Given I am on the IIEST Campus Portal login page
    When I enter valid username "your_username" and password "your_password"
    And I click the Login button
    Then I should be redirected to the dashboard page

  Scenario: Unsuccessful Login with Invalid Credentials
    Given I am on the IIEST Campus Portal login page
    When I enter invalid username "invalid_user" and password "wrong_pass"
    And I click the Login button
    Then I should see an error message indicating login failure
    And I should remain on the login page
