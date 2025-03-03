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

    @Given("I have a JIRA address and a valid API KEY")
    public void given_jira_address_and_valid_api_key() {
        request = given().spec(requestSpecBuilder().build());
    }

    @When("I call {string} {string} which {string}")
    public void user_call_http_request_method_with_id(String methodHttp, String resource, String projectId) {
        ApiResourcesEnum apiResource = ApiResourcesEnum.valueOf(resource);
        chooseHttpRequestMethod(methodHttp, projectId, apiResource);
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

    private void chooseHttpRequestMethod(String methodHttp, String projectId, ApiResourcesEnum apiResource) {
        switch (methodHttp.toUpperCase()) {
            case "GET":
                response = request.when().get(apiResource.getResource() + projectId);
                break;
            case "POST":
                response = request.when().post(apiResource.getResource() + projectId + "/restore");
                break;
            case "DELETE":
                response = request.when().delete(apiResource.getResource() + projectId);
                break;
        }
    }
}
