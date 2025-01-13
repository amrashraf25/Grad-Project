@Smoke

Feature: F01_Register | users could register with new accounts

  Scenario: guest user could register with valid data successfully
    Given user go to sign up page
    And user enter username "testuser" and password "P@ssw0rd"
    And user clicks on sign up button
    Then success message is displayed