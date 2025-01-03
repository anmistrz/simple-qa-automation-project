$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Checkout.feature");
formatter.feature({
  "name": "Checkout Product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Checkout a Product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click the add to cart button \u003clistOfProducts\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I click the cart button",
  "keyword": "And "
});
formatter.step({
  "name": "I click the checkout button",
  "keyword": "And "
});
formatter.step({
  "name": "I fill in the checkout information with \"\u003cfirst_name\u003e\", \"\u003clast_name\u003e\", and \"\u003cpostal_code\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I click the continue button",
  "keyword": "And "
});
formatter.step({
  "name": "I verify the products before finishing the purchase \u003clistOfProducts\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I click the finish button",
  "keyword": "And "
});
formatter.step({
  "name": "I should see the thank you message",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "listOfProducts",
        "first_name",
        "last_name",
        "postal_code"
      ]
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce",
        "Sauce Labs Bike Light,Sauce Labs Bolt T-Shirt",
        "Ayu",
        "Puspita",
        "12345"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am in the homepage from login with \"standard_user\" and \"secret_sauce\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_am_in_the_homepage(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Checkout a Product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click the add to cart button Sauce Labs Bike Light,Sauce Labs Bolt T-Shirt",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_click_the_product(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the cart button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_click_the_cart_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the checkout button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_click_the_checkout_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill in the checkout information with \"Ayu\", \"Puspita\", and \"12345\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_fill_in_the_checkout_information_with_and(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the continue button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_click_the_continue_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the products before finishing the purchase Sauce Labs Bike Light,Sauce Labs Bolt T-Shirt",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_verify_the_products_before_finishing_the_purchase(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the finish button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_click_the_finish_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the thank you message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_should_see_the_thank_you_message()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Filter.feature");
formatter.feature({
  "name": "Filter Product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Filter a Product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click the filter button",
  "keyword": "When "
});
formatter.step({
  "name": "I choose the filter \"\u003cfilter\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I should see the products filtered by \"\u003cfilter\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "filter"
      ]
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce",
        "Price (low to high)"
      ]
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce",
        "Price (high to low)"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am in the homepage from login with \"standard_user\" and \"secret_sauce\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_am_in_the_homepage(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Filter a Product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click the filter button",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsFilter.i_filter_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I choose the filter \"Price (low to high)\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsFilter.i_choose_the_filter_and_see_the_products(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the products filtered by \"Price (low to high)\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsFilter.i_should_see_the_products_filtered_by(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am in the homepage from login with \"standard_user\" and \"secret_sauce\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsCheckout.i_am_in_the_homepage(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Filter a Product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I click the filter button",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsFilter.i_filter_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I choose the filter \"Price (high to low)\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsFilter.i_choose_the_filter_and_see_the_products(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the products filtered by \"Price (high to low)\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitions.StepDefinitionsFilter.i_should_see_the_products_filtered_by(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});