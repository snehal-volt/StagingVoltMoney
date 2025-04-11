Feature: Home page functionality post login

  Background:
    Given User is logged in

  Scenario:
    Given User should be on the homepage
    And User clicks on Continue Application button
    Then User should navigate to next page
