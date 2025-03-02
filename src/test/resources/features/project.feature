Feature: Jira Project API
  User wants to know details about specific project

  Scenario Outline: Get a details project using API
    Given Jira API is active
    When I GET project which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10000     | 200              |
      | 99999     | 404              |