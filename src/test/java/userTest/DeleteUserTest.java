package userTest;

import common.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest extends BaseTest {
    @Test
    public void DeleteUser() {
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .when()
                .delete("public-api/users/123")
                .then().statusCode(200).log().body();
    }
}