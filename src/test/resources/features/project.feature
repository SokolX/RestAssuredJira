Feature: Jira Project API

  Scenario Outline: Get all projects using API
    Given Jira API is active
    When I call GET "ProjectAPI"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | expectedHttpCode |
      | 200              |

  Scenario Outline: Get a details project using API
    Given Jira API is active
    When I call GET "ProjectAPI" which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10000     | 200              |
      | 99999     | 404              |

  Scenario Outline: Delete project using API
    Given Jira API is active DELETE
    When I call DELETE "ProjectAPI" which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10003     | 204              |
      | 99999     | 404              |

  Scenario Outline: Restore deleted project using API
    Given Jira API is active POST
    When I call POST "ProjectAPI" which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10003     | 200              |
      | 99999     | 404              |