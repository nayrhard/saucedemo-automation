Feature: Checkout product

  @Regression @Possitive
  Scenario: Verify User is able to buy
    Given Open browser Apps
    And Open saucedemo Website
    And Located on saucedemo web
    When Users input username and Password and then login
    And Users click Add to cart Button to buy one or more product
    And User click icon cart
    And User click checkout button
    And Input Firstname, Lastname and Zip Code
    And Click Continue Button
    And Click Finish
    Then user is on checkout complete page

  #@Regression @Negative
  #Scenario: Verify User is can't buy without completed buyer's data


