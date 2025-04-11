Feature: Login functionality with phone number and OTP

  Background:
    Given User is on Volt Money Login page

  Scenario Outline: Successful login with valid credentials
    Given user clicks and enters valid number <phone_number>
    Then user clicks on Continue button if it is enabled
    When user receives the OTP and enters <otp>
    Then user should be logged in successfully

    Examples:
      | phone_number| otp   |
      | 8828117336  | 222222|

#  Scenario Outline: Unsuccessful login with invalid credentials
#    Given user clicks and enters valid <phone_number>
#    Then user clicks on Continue button if it is enabled
#    And user should be redirected to OTP Page
#    When user receives the OTP and enters <otp>
#    Then user should see message indicating error:"<error_message>"
#
#    Examples:
#      | phone_number| otp   | error_message                                      |
#      | 1088997358  | 123456|123456 is not a valid OTP. You have 4 attempts left.|
