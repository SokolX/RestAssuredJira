package pl.soek.jira.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import pl.soek.jira.config.ConstansJira;

import static pl.soek.jira.config.ConstansJira.JIRA_API_KEY;

public class RequestSpec {

    public static RequestSpecBuilder requestSpecBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(ConstansJira.JIRA_URL)
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
                .addHeader("Authorization", JIRA_API_KEY);
    }

}
