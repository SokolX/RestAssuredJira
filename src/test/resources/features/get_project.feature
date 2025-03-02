Feature: Get a specific project from Jira
  User wants to know details about specific project

  Scenario: Get a details project using API
    Given Get a project with details
    When user calls Get http method project
    Then the API returned Success
