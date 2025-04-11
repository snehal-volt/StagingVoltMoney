Feature: Bank functionality post login

  Background:
    Given User is logged in
    And User clicks on Continue Application button
    And User clicks on Start button

  Scenario Outline: Bank Steps
    Given User is on Link Bank account page
    When User clicks on Add Bank account
    Then User is shown Select your bank page
    When User clicks on popular bank "<bankName>"
    Then User is shown Enter account details page
    Then User clicks and enters bank account number "<bankAccountNumber>"
    Then User clicks and enters ifsc code "<ifscCode>"
    And User selects ifsc code
    And User clicks on Verify bank account button

    Examples:
      | bankName | bankAccountNumber | ifscCode    |
      | icici    | 1233943142        | ICIC0000009 |