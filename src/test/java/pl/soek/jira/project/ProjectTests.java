package pl.soek.jira.project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import pl.soek.jira.model.project.Project;

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

        Response response = request.get("rest/api/3/project/");

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", not(empty()))
                .body("$", hasSize(1))
                .body("[0].name", equalTo("RestAssured"));

        List<Project> returnedProjects = Arrays.asList(response.as(Project[].class));
        assert returnedProjects.size() == 1;
    }

    @Test
    public void shouldReturnProjectById() {
        RestAssured.baseURI = JIRA_URL;

        given()
                .header("Content-Type","application/json")
                .header("Authorization", JIRA_API_KEY)
                .log().all()
                .get("rest/api/3/project/10000").then().log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .extract().response().asString();
    }
}
