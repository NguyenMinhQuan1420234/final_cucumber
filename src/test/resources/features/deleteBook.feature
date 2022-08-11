@DeleteBook
Feature: Delete Book
  As a user, I'd like to delete book in my collection

  Scenario: Delete book successfully
    Given there is a book named “Git Pocket Guide”
    And the user logs into the application
    And the user is on the Profile page
    When the user search book "Git Pocket Guide"
    And the user clicks on Delete icon
    And the user clicks on OK button
    And the user clicks on OK button of alert “Book deleted.”
    And the book is not shown