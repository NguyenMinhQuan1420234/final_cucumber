@Register_Student_Form
Feature: Register student form
  As a valid user I would like to register student form

  Scenario Outline: Register student form with all fields/ mandatory fields successfully
    And the user is on Student Registration Form
    When the user input valid data into all fields.
      | First Name  | Last Name  | Email   | Gender   | Mobile   | Date of birth | Subjects   | Hobbies   | Picture   | Current Address | State   | City   |
      | <firstname> | <lastname> | <email> | <gender> | <mobile> | <dob>         | <subjects> | <hobbies> | <picture> | <address>       | <state> | <city> |
    And the user clicks on Submit button
    Then a successful message "Thanks for submitting the form" is shown
    And all information of the student form is shown correctly.
    Examples:
      | firstname | lastname | email                | gender | mobile     | dob               | subjects                   | hobbies | picture  | address | state | city  |
      | quan      | nguyen   | validemail@yahoo.com | Male   | 0730945860 | 05 September,1996 | Maths, Physics, Accounting | Reading | hinh.jpg | Go Vap  | NCR   | Delhi |
      | sieunhan  | do       |                      | Female | 0730945860 |                   |                            |         |          |         |       |       |