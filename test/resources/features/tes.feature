Feature: Date Picker Selection
  As a user of the application
  I want to select a date from a popup calendar
  To avoid errors when entering dates manually

  @SelectDate @Smoke
  Scenario: Select date in a different month
    Given the user opens the Datepicker page
    When the user selects day "20" navigating "3" months forward
    Then the user should see the date "02/20/2026" in the field

  @VerifyCalendar @Smoke
  Scenario: Verify calendar displays on click
    Given the user opens the Datepicker page
    When the user clicks on the date field
    Then the calendar should be visible

  @NavigateBackward @Regression
  Scenario: Navigate months backward
    Given the user opens the Datepicker page
    When the user navigates "2" months backward and selects day "15"
    Then the user should see the date "09/15/2025" in the field

  @MultipleMonths @Regression
  Scenario Outline: Select date navigating multiple months
    Given the user opens the Datepicker page
    When the user selects day "<day>" navigating "<months>" months forward
    Then the user should see the date "<expected_date>" in the field

    Examples:
      | day | months | expected_date |
      | 15  | 1      | 12/15/2025    |
      | 10  | 6      | 05/10/2026    |
      | 28  | 12     | 11/28/2026    |