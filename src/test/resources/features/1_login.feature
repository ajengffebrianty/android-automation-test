Feature: Login feature

  Scenario: Access login page
    Given the app is launched
    Then I navigate to login screen

    Scenario: Validate required login field
      Given I'm on login screen
      When I tap the login button
      Then I should see error message under username field "Username is required"
      When I enter username "bod@example.com" and password ""
      And I tap the login button
      Then I should see error message under password field "Enter Password"
      When I clear the username
      Then I enter password "10203040"
      And I tap the login button
      Then I should see error message under username field "Username is required"

  Scenario: Failed login with user locked out
    Given the app is launched
    When I navigate to login screen
    And I enter username "alice@example.com" and password "10203040"
    And I tap the login button
    Then I should see error message under password field "Sorry this user has been locked out."

Scenario: Login use valid
  Given the app is launched
  When I navigate to login screen
  And I enter username "bod@example.com" and password "10203040"
  And I tap the login button
  Then I should redirect to Products page

  Scenario: Activate biometric login
    Given the app is launched
    When I navigate to Fingerprint page
    When I enable to login with Fingerprint
    When I navigate to login screen
    Then I should see fingerprint button
