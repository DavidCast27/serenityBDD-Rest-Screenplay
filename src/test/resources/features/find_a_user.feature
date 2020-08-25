Feature: find a user information
  I as a app need to find a user with your ID because i need show your information

  Scenario: find a user valid
    When he find a user with id 1
    Then response status code is 200
    And user whit first name "George" and last name "Bluth" should be correct
