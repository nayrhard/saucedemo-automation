Feature: Logout Page Website Saucedemo

  @Regression @Positive
  Scenario: User logout from dashboard
    Given user login
    When user tap navigation button
    And user click logout button
    Then user back to login page