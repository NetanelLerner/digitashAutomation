package api.framework;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import static api.framework.JsonUtil.objectToJson;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Slf4j
public class APIManager {
    public static final ThreadLocal<String> apiAuthToken = new ThreadLocal<>();

    @Synchronized
    public static void setLocalStorageAuthToken(String accessToken) {
        apiAuthToken.set(accessToken);
    }

    @Synchronized
    public static String authorize(String userTaz) {
        log.info("Authenticating...");

        String accessToken = given()
                .contentType(JSON)
                .post("https://app-tash-api-dev.azurewebsites.net/login/automation/"+userTaz)
                .jsonPath()
                .get("accessToken");
        setLocalStorageAuthToken(accessToken);

        return accessToken;
    }

    @Synchronized
    protected static RequestSpecification specification() {
        String localToken = apiAuthToken.get();

        Header auth = new Header("Authorization", "Bearer " + localToken);
        RequestSpecBuilder requestSpeck = new RequestSpecBuilder();
        requestSpeck.addHeader(auth.getName(), auth.getValue())
                .addFilter(new AllureRestAssured());

        return requestSpeck.build();
    }
}
