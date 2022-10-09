@regression @board
Feature: board feature

  Background:
    Given user is on the home page
    When user navigate to team page

  @positive @board_001
  Scenario: verify user can navigate to board page using board card
    Given user is on the team page
    When user select board card
    Then user should be navigated to board page

  @positive @board_002
  Scenario: verify user can navigate to board page using overview option button
    Given user is on the team page
    When user select board menu in the overview option button
    Then user should be navigated to board page

  @positive @board_003
  Scenario: verify user can add list on board page
    Given user is on the team page
    When user select board card
    And user create new list
    Then list should be successfully created

  @positive @board_004
  Scenario: verify user can select list action menu
    Given user is on the team page
    When user select board card
    And user select list action menu
    Then list action menu should be displayed

  @positive @board_005
  Scenario: verify user can set as a complete list using list action menu
    Given user is on the team page
    When user select board card
    And user select set as complete list from list action menu
    Then list should be set as complete

  @positive @board_006
  Scenario: verify user can unset complete list using list action menu
    Given user is on the team page
    When user select board card
    And user select unset complete list from list action menu
    Then list should be set as incomplete

  @positive @board_007
  Scenario: verify user can add card on board page
    Given user is on the team page
    When user select board card
    And user create new card
    Then card successfully created

  @negative @board_008
  Scenario: verify user can add card on board page and set as private, by clicking submit first then clicking private toggle
    Given user is on the team page
    When user select board card
    And user create new card
    And user set card as private
    Then card successfully created as private

  @positive @board_009
  Scenario: verify user can add card on board page and set as private
    Given user is on the team page
    When user select board card
    And user create new private card
    Then card successfully created as private

  @positive @board_011
  Scenario: verify user can't create list with empty list name
    Given user is on the team page
    When user select board card
    And user create new list with empty list name
    Then user should see error message List name cannot be empty

  @positive @board_012
  Scenario: verify user can't create card with empty card name
    Given user is on the team page
    When user select board card
    And user create new card with empty card name
    Then user should see error message Card name cannot be empty

  @positive @board_010
  Scenario: verify user can archive list using list action menu
    Given user is on the team page
    When user select board card
    And user archive the list
    Then list successfully archived