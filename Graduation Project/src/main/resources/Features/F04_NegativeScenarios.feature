@Smoke

Feature: F04_NegativeScenarios | users could face negative scenarios

  Scenario: user could not register with existing username
    Given user go to sign up page
    And user enter username "testuser" and password "P@ssw0rd"
    And user clicks on sign up button
    Then error message "This user already exist." is displayed

  Scenario: user could not login with invalid credentials
    Given user go to login page
    And user enter login username "wronguser" and password "wrongpass"
    And user clicks on login button
    Then login error message "Wrong password." is displayed

  Scenario: user could not add the same product twice to cart
    Given user go to home page
    And user add product to cart
    And user navigate to cart
    Then product "Samsung galaxy s6" should be in cart
    And user add product to cart again
    Then error message "Product already added to cart." is displayed