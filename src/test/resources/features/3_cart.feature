Feature: Cart feature

  Background:
    Given the app is launched

  Scenario: Access carts page
    When Reset app state
    And Press cart icon on right side
    Then Page will redirect to carts page
    And No items title and Go shopping button will show if cart is empty
    And List of product and proceed to checkout button will show if cart is not empty

  Scenario: Add product into carts
    Given user in product detail page
    When user press add to cart button
    And Press cart icon on right side
    Then verify the product has been added

  Scenario: Add product to cart with more than one quantity
    Given user in product detail page
    When user sets the product quantity to more than one
    And user press add to cart button
    Then the cart should contain the product with the selected quantity

  Scenario: Add more than one product to the cart
    Given user in product page
    When user adds the first product to the cart
    And user adds another product to the cart
    Then the cart should contain more than one product

  Scenario: Check element functionality on the cart page
    Given user has added multiple products to the cart
    And user is on the cart page
    When user check counter functionality in cart page
    Then quantity will increased or decreased in cart page
    When user taps the "Proceed to Checkout" button
    Then user should be redirected to the login page

