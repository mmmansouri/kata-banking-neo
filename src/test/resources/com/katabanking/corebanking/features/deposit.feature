Feature: Deposit an amount of money into personal account

  As a bank client,
  I want to make a deposit in my account,
  So that I save money,

  Scenario: Successful deposit
    Given a bank client Account to make a deposit
    When  the client ask to deposit 10
    Then  the Account is credited with the given 10 of Money