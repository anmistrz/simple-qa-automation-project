Feature: Checkout Product

Background:
    Given I am in the homepage from login with "standard_user" and "secret_sauce"

@Tag("profileTest")  
Scenario Outline: Checkout a Product
    When I click the add to cart button <listOfProducts>
    And I click the cart button
    And I click the checkout button
    And I fill in the checkout information with "<first_name>", "<last_name>", and "<postal_code>"
    And I click the continue button
    And I verify the products before finishing the purchase <listOfProducts>
    And I click the finish button
    Then I should see the thank you message

    Examples:
        | username      |  password    | listOfProducts                                                    | first_name | last_name | postal_code |
        | standard_user | secret_sauce | Sauce Labs Bike Light,Sauce Labs Bolt T-Shirt                     | Ayu        | Puspita   | 12345       |