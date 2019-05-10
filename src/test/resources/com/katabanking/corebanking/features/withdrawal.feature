Feature: withdraw an amount of money from personal account

  As a bank client,
  I want to make a withdrawal from my account,
  So I retrieve some or all of my savings,

  Scenario: Successful withdrawal
    Given a bank client Account to withdraw
    When  the client ask to withdraw 10
    Then  the Account is debited with the given 10 of Money