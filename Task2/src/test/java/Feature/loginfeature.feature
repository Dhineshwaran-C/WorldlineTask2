Feature: Login Action
    Description: This feature will test a LogIn and LogOut functionality

    Scenario: Login with valid Credentials
        Given User is on Home Page
        When User navigate to Login Page
        Then User enters "<username>" and "<password>"
        And Keeping case "<Case>" as Valid
        Then User should get logged in
        And Message displayed Login Successfully or not
        Then Keeping case "<Case>" as InValid
        And user will be asked to go back to login page if user is InValid "<Case>"
        Then Provide correct credentials if user is InValid "<Case>"

    Examples:
        | username          | password | Case   |
        | practice | SuperSecretPassword! | Valid  |
        | abc1@gmail.com   | dfsd2    | InValid |