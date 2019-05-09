Feature: Deposit an amount of money into personal account

  As a bank client,
  I want to make a deposit in my account,
  So that I save money,

  Scenario: Successful deposit
    Given a bank client Account
    When  the client ask to deposit Money
    Then  the Account is credited with the given amount of Money