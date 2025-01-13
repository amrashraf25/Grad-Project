@Smoke

Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
    Given user go to login page
    And user enter username "testuser" and password "P@ssw0rd"
    And user clicks on login button
    Then user login to the system successfully