Feature: Account history retrieval

  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations
  So I check my operations

  Scenario: Successful history retrieval
    Given a bank client Account with transactions history
    When  the client ask for account transactions history
    Then  the Account transactions history is returned