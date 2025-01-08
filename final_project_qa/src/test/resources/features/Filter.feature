Feature: Filter Product

Background:
    Given I am in the homepage from login with "standard_user" and "secret_sauce"

@Tag("profileTest")
Scenario Outline: Filter a Product
    When I click the filter button
    And I choose the filter "<filter>"
    Then I should see the products filtered by "<filter>"

    Examples:
        | username      |  password    | filter |
        | standard_user | secret_sauce | Price (low to high) |
        | standard_user | secret_sauce | Price (high to low) |