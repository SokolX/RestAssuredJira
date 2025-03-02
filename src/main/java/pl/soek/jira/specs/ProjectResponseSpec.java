package pl.soek.jira.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ProjectResponseSpec {

    public static ResponseSpecBuilder codeHttpResponse(String expectedHttpCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(Integer.parseInt(expectedHttpCode))
                .expectContentType(ContentType.JSON);
    }

    public static ResponseSpecification successResponseAllProject(String expectedHttpCode) {
        return codeHttpResponse(expectedHttpCode)
                .expectBody("$", not(empty()))
                .expectBody("$", hasSize(1))
                .expectBody("[0].name", equalTo("RestAssured"))
                .build();
    }

    public static ResponseSpecification successResponseProjectById(String expectedHttpCode,
                                                                   String expectedName) {
        return codeHttpResponse(expectedHttpCode)
                .expectBody("name", equalTo(expectedName))
                .build();
    }
}
