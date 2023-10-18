Feature: Songs Tests

  Scenario: Play song
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I click submit
    And I click play button
    Then I see equalizer