Feature: Mandate functionality post login

  Background:
    Given User is logged in
    And User clicks on Continue Application button
    And User clicks on Start button

  Scenario Outline: Mandate Reject Steps and Mandate accept with same bank account
    Given User is on Setup Mandate page
    When User clicks on Continue button on Mandate page
    Then User selects Verification Mode "<verificationMode>"
    And User clicks on authorization checkbox
    And User clicks on Submit button
#    And User clicks on Reject Mandate
#    Then User is shown Mandate Request failed half card
#    And User clicks on Try again with same bank account button
#    And User clicks on authorization checkbox
#    And User clicks on Submit button
    And User clicks on Accept button

    Examples:
    | verificationMode |
    | Debit            |