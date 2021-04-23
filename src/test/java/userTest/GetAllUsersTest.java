package userTest;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTest {

    @Test
    public void getResponseBody() {

        given()
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when().get("https://gorest.co.in/public-api/users").then().log()
                .body();
    }
}