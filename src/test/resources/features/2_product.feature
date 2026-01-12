Feature: Product feature

  Background:
    Given the app is launched

  Scenario: Access Product page
    Then the product list should be displayed
    And the product images should be displayed
    And the product prices should be displayed

  Scenario: Check sort functionality
    When sort button clicked
    Then sort by-name-ascending will selected as default
    Then product name should be show in ascending order
    When product sort by-name-descending selected
    Then product name should be show in descending order
    When product sort by-price-ascending selected
    Then product price should be show in ascending order
    When product sort by-price-descending selected
    Then product price should be show in descending order

  Scenario: Check product detail page
    When Select one of product
    Then page should be show the product detail

  Scenario: Check product detail element functionality
    When  Select one of product
    Then Check if color button can be clicked
    When user check counter functionality
    Then quantity increased or decreased
    When user presses the Add to cart button
    Then Cart number changed