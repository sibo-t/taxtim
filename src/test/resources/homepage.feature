@web
Feature: Tax Tim

  Background:
    Given the user sets tax year "2022"
    And the user gross salary is "20000"
    And the salary is received "monthly"

  @HR-39-1 @HR-39-2
  Scenario Outline: Validate that a user can successfully use a discount
    Given As a user, I want to calculate tax when the age is 22
    When the user press the calculate button
    Then As a user, I want to calculate tax when the take home "<take_home>"
    Then As a user, I want to calculate tax when the tax "<take_home>"

    Examples:
      | take_home                   |tax              |
      | Successfully added discount | 200             |