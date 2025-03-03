Feature: Jira Project API

  Scenario Outline: Get all projects using API
    Given I have a JIRA address and a valid API KEY
    When I call GET "ProjectAPI"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | expectedHttpCode |
      | 200              |

  Scenario Outline: Get a details project using API
    Given I have a JIRA address and a valid API KEY
    When I call "GET" "ProjectAPI" which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10003     | 200              |
      | 99999     | 404              |

  Scenario Outline: Delete project using API
    Given I have a JIRA address and a valid API KEY
    When I call "DELETE" "ProjectAPI" which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10003     | 204              |
      | 99999     | 404              |

  Scenario Outline: Restore deleted project using API
    Given I have a JIRA address and a valid API KEY
    When I call "POST" "ProjectAPI" which "<projectId>"
    Then the API call status "<expectedHttpCode>"
    Examples:
      | projectId | expectedHttpCode |
      | 10003     | 200              |
      | 99999     | 404              |