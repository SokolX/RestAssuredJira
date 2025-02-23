package pl.soek.jira.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ProjectResponseSpec {

    private static ResponseSpecBuilder successRespose() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON);
    }

    public static ResponseSpecification successResponseAllProject() {
        return successRespose()
                .expectBody("$", not(empty()))
                .expectBody("$", hasSize(1))
                .expectBody("[0].name", equalTo("RestAssured"))
                .build();
    }

    public static ResponseSpecification successResponseProjectById() {
        return successRespose()
                .expectBody("name", equalTo("RestAssured"))
                .build();
    }
}
