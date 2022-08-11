@SearchBook
Feature: Search book
  As a user, I'd like to search book and get correct results

  Scenario Outline: : Search book with multiple results
    Given there are books named "Learning JavaScript Design Patterns" and "Designing Evolvable Web APIs with ASP.NET"
    And the user is on Book Store page
    When the user inputs book name Design or design
      | input   |
      | <input> |

    Then all books match with input criteria will be displayed.
    Examples:
      | input  |
      | Design |
      | design |