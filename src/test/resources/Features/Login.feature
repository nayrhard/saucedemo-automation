Feature: Login Page Website Saucedemo

  @Regression @Possitive
  Scenario: Verify User is able to login with given username and Password
    Given Open browser
    And Open saucedemo Web App
    And Located on saucedemo website
    When The Users input with registered username
    And The Users input with registered Password
    And The User click button Login
    Then user is on dashboard page

  @Regression @Negative
  Scenario: Verify User is unable to login with random username and Password
    Given Open browser
    And Open saucedemo Web App
    And Located on saucedemo website
    When The Users input with random or unregistered username
    And The Users input with random or unregistered password
    And The User click button Login
    Then user get error message

