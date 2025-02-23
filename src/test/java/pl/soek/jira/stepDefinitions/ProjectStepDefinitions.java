package pl.soek.jira.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.soek.jira.specs.ProjectResponseSpec;

import static io.restassured.RestAssured.given;
import static pl.soek.jira.config.ConstansJira.JIRA_API_KEY;
import static pl.soek.jira.config.ConstansJira.JIRA_URL;

public class ProjectStepDefinitions {

    RequestSpecification request;
    Response response;

    @Given("Get a project with details")
    public void get_a_project_with_details() {
        RestAssured.baseURI = JIRA_URL;

        request = given()
                .header("Content-Type", ContentType.JSON)
                .header("Authorization", JIRA_API_KEY);
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
