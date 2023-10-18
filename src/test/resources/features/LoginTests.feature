Feature: Login Tests

  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I click submit
    Then I logged in