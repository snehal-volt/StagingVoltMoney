Feature: Stepper page functionality post login

  Background:
    Given User is logged in
    And User clicks on Continue Application button

  Scenario:
    Given User is on the stepper page
    And User clicks on Start button
    Then User should navigate to next page