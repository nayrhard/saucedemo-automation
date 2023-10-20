Feature: Cart

  @Regression @Positive1
  Scenario: Verify User can continue to buy without add item to cart and without completed buyer's data
    Given Open browser Web
    And Open saucedemo Web
    And Located on saucedemo web app
    When User input username and Password and then login
    And User click icon cart without click Add to cart Button
    And User click Checkout button
    And user not Input Firstname and Lastname and zipcode
    And Click Button Continue
    Then user get error messages