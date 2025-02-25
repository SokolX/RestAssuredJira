package pl.soek.jira.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static pl.soek.jira.config.ConstansJira.JIRA_API_KEY;

public class RequestSpec {

    public static RequestSpecification basedHeader() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
                .addHeader("Authorization", JIRA_API_KEY)
                .build();
    }
}
