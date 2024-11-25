@must
Feature: To test login functionality

  Background: 
    Given Browser is open
    And I am on login page
@sanity
  Scenario Outline: login with valid credentials
    When I enter <username> and <password>
    And I hit submit button
    Then I am navigated to home page
    And I click X button to close page

    Examples: 
      | username | password    |
      | student  | Password123 |
@smoke
  Scenario Outline: login with invalid credentials
    When I enter <username> and <password>
    And I hit submit button
    Then I get error message- Your username is invalid
    And I click X button to close page

    Examples: 
      | username      | password    |
      | incorrectUser | Password123 |
@Smoke
  Scenario Outline: login with invalid credentials
    When I enter <username> and <password>
    And I hit submit button
    Then I get error message- Your password is invalid
    And I click X button to close page

    Examples: 
      | username      | password    |
      | student | incorrectPassword |
