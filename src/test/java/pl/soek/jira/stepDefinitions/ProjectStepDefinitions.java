package pl.soek.jira.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.soek.jira.specs.ProjectResponseSpec;
import pl.soek.jira.specs.RequestSpec;

import static io.restassured.RestAssured.given;

public class ProjectStepDefinitions {

    RequestSpecification request;
    RequestSpec requestSpec = new RequestSpec();
    Response response;

    @Given("Get a project with details")
    public void get_a_project_with_details() {
        request = given().spec(requestSpec.requestSpecBuilder().build());
    }

    @When("user calls Get http method project")
    public void user_calls_GetProject_with_Get_httpRequest() {
        response = request.when().get("rest/api/3/project/10000");
    }

    @Then("the API returned Success")
    public void the_API_returned() {
        response.then().spec(ProjectResponseSpec.successResponseProjectById()).extract().response();
    }
}
