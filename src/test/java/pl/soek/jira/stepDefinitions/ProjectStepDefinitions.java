package pl.soek.jira.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.soek.jira.specs.ProjectResponseSpec;

import static io.restassured.RestAssured.given;
import static pl.soek.jira.specs.RequestSpec.requestSpecBuilder;

public class ProjectStepDefinitions {

    RequestSpecification request;
    Response response;

    @Given("Jira API is active")
    public void get_a_project_with_details() {
        request = given().spec(requestSpecBuilder().build());
    }

    @When("I GET project which {string}")
    public void user_calls_GetProject_with_Get_httpRequest(String projectId) {
        response = request.when().get("rest/api/3/project/" + projectId);
    }

    @Then("the API call status {string}")
    public void the_API_returned(String expectedHttpCode) {
        response.then().spec(ProjectResponseSpec.codeHttpResponse(expectedHttpCode).build()).extract().response();
    }
}
