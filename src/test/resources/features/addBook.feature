@Add_Book
Feature: Add book to your collection
  As a User, I'd like to add book to my collection

  Scenario Add book to your collection
    Given the user logs into application
    And the user is on Book Store page
    When the user selects a book "Git Pocket Guide"
    And the user clicks on Add To Your Collection
    Then an alert "Book added to your collection." is shown
    And book is shown in your profile