package userTest;

import common.BaseTest;
import model.dataProvider.UserDataProvider;
import model.etities.UserEntity;
import org.json.simple.JSONObject;
import org.junit.Test;
import util.Utils;

import static io.restassured.RestAssured.given;

public class UpdateUserTest extends BaseTest {
    UserEntity currentUser;

    @Test
    public void UpdateUser() {
        currentUser = UserDataProvider.NEW_USER;
        JSONObject jsonObject = Utils.getJsonObject(currentUser);
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .put("public-api/users/123").then().statusCode(200).log().all();
    }
}
