package pl.soek.jira.project;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static pl.soek.jira.config.ConstansJira.JIRA_API_KEY;
import static pl.soek.jira.config.ConstansJira.JIRA_URL;

public class ProjectTests {

    @Test
    public void shouldCreatedProject() {
        ObjectNode payload = preparePaylaodProject();

        RestAssured.baseURI = JIRA_URL;

        given()
                .header("Content-Type","application/json")
                .header("Authorization", JIRA_API_KEY)
                .body(payload)
                .log().all()
                .post("rest/api/3/project/").then().log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .extract().response().asString();
    }

    @Test
    public void shouldGetAllProjects() {
        RestAssured.baseURI = JIRA_URL;

        given()
                .header("Content-Type","application/json")
                .header("Authorization", JIRA_API_KEY)
                .log().all()
                .get("rest/api/3/project/").then().log().all()
                .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                .extract().response().asString();
    }


    private static ObjectNode preparePaylaodProject() {
        JsonNodeFactory jnf = JsonNodeFactory.instance;
        ObjectNode payload = jnf.objectNode();
        {
            payload.put("assigneeType", "PROJECT_LEAD");
            payload.put("avatarId", 10200);
            payload.put("categoryId", 10120);
            payload.put("description", "Cloud migration initiative");
            payload.put("issueSecurityScheme", 10001);
            payload.put("key", "EX");
            payload.put("leadAccountId", "5b10a0effa615349cb016cd8");
            payload.put("name", "Example");
            payload.put("notificationScheme", 10021);
            payload.put("permissionScheme", 10011);
            payload.put("projectTemplateKey", "com.atlassian.jira-core-project-templates:jira-core-simplified-process-control");
            payload.put("projectTypeKey", "business");
            payload.put("url", "http://atlassian.com");
        }
        return payload;
    }
}
