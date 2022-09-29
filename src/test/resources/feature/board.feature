@regression
Feature: board feature

  Background:
    Given user is on the home page
    When user click team card
    Then user should be navigated to team page

  @board_001
  Scenario: user can navigate to board page using board icon
    Given user is on the team page
    When user click board card
    Then user should be navigated to board page

  @board_002
  Scenario: user can navigate to board page using overview option button
    Given user is on the team page
    When user click board in the overview option button
    Then user should be navigated to board page

  @board_003
  Scenario: user can add list on board page
    Given user click board card
    When user create new list
    Then list should be successfully created

  @board_004
  Scenario: user can click list action menu
    Given user click board card
    When user click list action menu
    Then list action menu should be displayed

  @board_005
  Scenario: user can click list action menu
    Given user click board card
    When user click set as complete list from list action menu
    Then list should be set as complete

  @board_006
  Scenario: user can click list action menu
    Given user click board card
    When user click unset complete list from list action menu
    Then list should be set as incomplete
