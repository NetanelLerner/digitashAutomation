package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;

public class BaseTests {

    @BeforeClass
    protected void setup() {
        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }

    public static void main(String[] args) {
        String token = given()
                .contentType(JSON)
                .post("https://app-tash-api-dev.azurewebsites.net/login/automation/324995273")
                .jsonPath()
                .get("accessToken");

        System.out.println(token);
    }
}