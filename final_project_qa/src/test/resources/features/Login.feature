# Feature: Login Application

#     Background:
#         Given I am in the login page

#     Scenario Outline: Login with valid credentials
#         When I enter the username "<username>" and password "<password>"
#         And I click the login button
#         Then I should see the homepage

#         Examples:
#             | username         | password        |
#             | standard_user    | secret_sauce    |

#     Scenario Outline: Login with invalid credentials
#         When I enter the username "<username>" and password "<password>"
#         And I click the login button
#         Then I should see the error message

#         Examples:
#             | username         | password        |
#             | invalid_user     | invalid_password|