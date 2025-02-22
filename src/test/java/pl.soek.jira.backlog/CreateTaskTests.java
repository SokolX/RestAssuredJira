package pl.soek.jira.backlog;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static pl.soek.jira.config.ConstansJira.JIRA_API_KEY;
import static pl.soek.jira.config.ConstansJira.JIRA_URL;

import java.io.File;

import org.junit.jupiter.api.Test;

public class CreateTaskTests {

    private static final String PATH_TO_BUG_IMAGE = "src/main/resources/attachments/bug-0001.png";

    @Test
    public void shouldCreatedBugTask() {

        RestAssured.baseURI = JIRA_URL;

        String createIssueResponse = given()
            .header("Content-Type","application/json")
            .header("Authorization", JIRA_API_KEY)
            .body("{\n"
                    + "    \"fields\": {\n"
                    + "       \"project\":\n"
                    + "       {\n"
                    + "          \"key\": \"SCRUM\"\n"
                    + "       },\n"
                    + "       \"summary\": \"Website items are not working- automation Rest Assured\",\n"
                    + "       \"issuetype\": {\n"
                    + "          \"name\": \"Bug\"\n"
                    + "       }\n"
                    + "   }\n"
                    + "}")
            .log().all()
            .post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).contentType("application/json")
            .extract().response().asString();

            JsonPath responseJson = new JsonPath(createIssueResponse);

            String issueId = responseJson.getString("id");

            given()
            .pathParam("key", issueId)
            .header("X-Atlassian-Token","no-check")
            .header("Authorization", JIRA_API_KEY)
                    .multiPart("file", new File(PATH_TO_BUG_IMAGE))
                    .log().all()
                    .post("rest/api/3/issue/{key}/attachments")
                    .then().log().all().assertThat().statusCode(200);
    }
}
