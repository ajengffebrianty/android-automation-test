Feature: Checkout Feature

  Background:
    Given the app is launched

  Scenario: Access checkout page
    Given user on cart page
    When Press "Proceed to Checkout" button
    And Login with valid username and password
    Then Page will redirect to checkout page to fill shipping address
