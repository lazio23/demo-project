Feature: User login on Flashscore

  Scenario Outline: Successful and unsuccessful login
    Given they open the Flashscore website
    When they accept cookies if present
    And they click on the login icon
    And they click continue with email
    And they enter email "<email>"
    And they enter password "<password>"
    And they click the login button
    Then they should see <result>

    Examples:
      | email               | password  | result                     |
      | will_i_am@ukr.net   | 12345678  | confirmation message       |
      | wrong@wrong.com     | wrongpass | warning messages           |