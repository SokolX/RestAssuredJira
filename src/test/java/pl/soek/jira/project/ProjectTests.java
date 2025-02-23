package pl.soek.jira.project;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import pl.soek.jira.model.project.Project;
import pl.soek.jira.specs.ProjectResponseSpec;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import static pl.soek.jira.config.ConstansJira.JIRA_API_KEY;
import static pl.soek.jira.config.ConstansJira.JIRA_URL;

public class ProjectTests {

    @Test
    public void shouldReturnAllProjects() {
        RestAssured.baseURI = JIRA_URL;

        RequestSpecification request = given()
                .header("Content-Type",ContentType.JSON)
                .header("Authorization", JIRA_API_KEY);

        Response response = request
                .when().get("rest/api/3/project/")
                .then().spec(ProjectResponseSpec.successResponseAllProject()).extract().response();

        List<Project> returnedProjects = Arrays.asList(response.as(Project[].class));
        assert returnedProjects.size() == 1;
    }

    @Test
    public void shouldReturnProjectById() {
        RestAssured.baseURI = JIRA_URL;

        RequestSpecification request = given()
                .header("Content-Type",ContentType.JSON)
                .header("Authorization", JIRA_API_KEY);

        new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("name", equalTo("RestAssured"))
                .build();

        request.when().get("rest/api/3/project/10000")
                .then().spec(ProjectResponseSpec.successResponseProjectById()).extract().response();

    }
}
