@regression @schedule

Feature: schedule feature

  Background:
    Given user is on the home page
    When user navigate to team page

  @positive @schedule_001
  Scenario: verify user can navigate to schedule page using schedule card
    Given user is on the team page
    When user select schedule card
    Then user should be navigated to schedule page

  @positive @schedule_002
  Scenario: verify user can navigate to schedule using overview option button
    Given user is on the team page
    When user select schedule menu in the overview option button
    Then user should be navigated to schedule page

  @positive @schedule_003
  Scenario: verify user can select create event button on the schedule menu
    Given user is on the team page
    When user select schedule card
    And user select create event button
    Then user should be navigated to create event page

  @positive @schedule_004
  Scenario: verify user can create event on the schedule menu
    Given user is on the team page
    When user select schedule card
    And user create event
    Then user should be successfully created event

  @positive @schedule_005
  Scenario: verify user can create private events
    Given user is on the team page
    When user select schedule card
    And user create private event
    Then user should be successfully created private event

  @negative @schedule_006
  Scenario: verify user can't create event with end date before start date
    Given user is on the team page
    When user select schedule card
    And user create event with end date before start date
    Then user should see error message Cannot choose end date time before start date time

  @negative @schedule_007
  Scenario: verify user can't create event with empty title
    Given user is on the team page
    When user select schedule card
    And user create event with empty title
    Then user should see error message Event title cannot be empty

  @positive @schedule_008
  Scenario: verify user can cancel create event
    Given user is on the team page
    When user select schedule card
    And user cancel create event
    Then user should be navigated to schedule page

  @positive @schedule_009
  Scenario: verify user can move calendar to specific month and year
    Given user is on the team page
    When user select schedule card
    And user move calendar to December 2023
    Then user should be move to December 2023

  @positive @schedule_010
  Scenario: verify user can create event using fill notes more than 200 characters
    Given user is on the team page
    When user select schedule card
    And user create event with fill notes more than 500 characters
    Then user should be successfully created event
