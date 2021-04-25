package userTest;

import common.BaseTest;
import io.restassured.response.Response;
import model.dataProvider.UserDataProvider;
import model.etities.UserEntity;
import org.json.simple.JSONObject;
import org.junit.Test;
import util.Utils;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTest extends BaseTest {
    UserEntity currentUser;

    @Test
    public void createUserPositive() {
        currentUser = UserDataProvider.NEW_USER;
        JSONObject jsonObject = Utils.getJsonObject(currentUser);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .post("/public-api/users");
        response.getBody().print();

        assertThat(response.getBody().jsonPath().getString("data.name"))
                .isEqualTo(currentUser.getName());

        assertThat(response.getBody().jsonPath().getString("data.gender"))
                .isEqualTo(currentUser.getGender());

        assertThat(response.getBody().jsonPath().getString("data.email"))
                .isEqualTo(currentUser.getEmail());

        assertThat(response.getBody().jsonPath().getString("data.status"))
                .isEqualTo(currentUser.getStatus());
    }

    @Test
    public void compareCreateUserAndGetByIdPositive() {
        currentUser = UserDataProvider.NEW_USER;
        JSONObject jsonObject = Utils.getJsonObject(currentUser);
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .post("/public-api/users");

        int userId = response.getBody().jsonPath().getInt("data.id");
        Response responseGetMethodByUserId= given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .get(String.format("public-api/users/%s", userId));

        assertThat(responseGetMethodByUserId.getBody().jsonPath().getString("data.name"))
                .isEqualTo(currentUser.getName());

        assertThat(responseGetMethodByUserId.getBody().jsonPath().getString("data.gender"))
                .isEqualTo(currentUser.getGender());

        assertThat(responseGetMethodByUserId.getBody().jsonPath().getString("data.email"))
                .isEqualTo(currentUser.getEmail());

        assertThat(responseGetMethodByUserId.getBody().jsonPath().getString("data.status"))
                .isEqualTo(currentUser.getStatus());
    }


    @Test
    public void createUserWithWrongEmailNegative() {
        currentUser = UserDataProvider.USER_WITH_WRONG_EMAIL;
        JSONObject jsonObject = Utils.getJsonObject(currentUser);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .post("/public-api/users");

        assertThat(response.getBody().jsonPath().getInt("code"))
                .isEqualTo(422);

        assertThat(response.getBody().jsonPath().getString("data.field"))
                .isEqualTo("[email]");

        assertThat(response.getBody().jsonPath().getString("data.message"))
                .isEqualTo("[is invalid]");
    }


    @Test
    public void createUserWithEmptyStatusNegative() {
        currentUser = UserDataProvider.USER_WITH_EMPTY_STATUS;
        JSONObject jsonObject = Utils.getJsonObject(currentUser);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .post("/public-api/users");

        assertThat(response.getBody().jsonPath().getInt("code"))
                .isEqualTo(422);

        assertThat(response.getBody().jsonPath().getString("data.field"))
                .isEqualTo("[status]");

        assertThat(response.getBody().jsonPath().getString("data.message"))
                .isEqualTo("[can't be blank]");
    }
}