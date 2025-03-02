package pl.soek.jira.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.soek.jira.config.ApiResourcesEnum;
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

    @Given("Jira API is active DELETE")
    public void delete_a_project() {
        request = given().spec(requestSpecBuilder().build());
    }

    @Given("Jira API is active POST")
    public void post_a_project_with_details() {
        request = given().spec(requestSpecBuilder().build());
    }

    @When("I call GET {string} which {string}")
    public void user_call_get_request_with_id(String resource, String projectId) {
        ApiResourcesEnum apiResource = ApiResourcesEnum.valueOf(resource);
        response = request.when().get(apiResource.getResource() + projectId);
    }

    @Then("the API call status {string}")
    public void the_API_returned(String expectedHttpCode) {
        response.then().spec(ProjectResponseSpec.codeHttpResponse(expectedHttpCode).build()).log().all().extract().response();
    }

    @When("I call GET {string}")
    public void user_call_get_request(String resource) {
        ApiResourcesEnum apiResource = ApiResourcesEnum.valueOf(resource);
        response = request.when().get(apiResource.getResource());
    }

    @When("I call DELETE {string} which {string}")
    public void user_call_put_request(String resource, String projectId) {
        ApiResourcesEnum apiResource = ApiResourcesEnum.valueOf(resource);
        response = request.when().log().all().delete(apiResource.getResource() + projectId);
    }

    @When("I call POST {string} which {string}")
    public void user_call_post_request(String resource, String projectId) {
        ApiResourcesEnum apiResource = ApiResourcesEnum.valueOf(resource);
        response = request.when().log().all().post(apiResource.getResource() + projectId + "/restore");
    }
}
