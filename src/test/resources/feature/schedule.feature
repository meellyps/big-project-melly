@regression @groupChat

Feature: group chat feature

  Background:
    Given user is on the home page
    When user navigate to team page

  @positive @groupChat_001
  Scenario: verify user can navigate to group chat page using group chat card
    Given user is on the team page
    When user select group chat card
    Then user should be navigated to group chat page

  @positive @groupChat_002
  Scenario: verify user can navigate to group chat using overview option button
    Given user is on the team page
    When user select group chat menu in the overview option button
    Then user should be navigated to group chat page

  @positive @groupChat_003
  Scenario: verify user can send text message
    Given user is on the team page
    When user select group chat card
    And send text message
    Then user should see the text message that has been sent

  @positive @groupChat_004
  Scenario: verify user can delete message
    Given user is on the team page
    When user select group chat card
    And user delete message
    Then user should see the text message that has been deleted

  @positive @groupChat_005
  Scenario: verify user can send text message
    Given user is on the team page
    When user select group chat card
    And send image massage
#    Then user should see the image message that has been sent