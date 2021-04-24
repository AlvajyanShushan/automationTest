package userTest;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateUserTest {
    @Test
    public void UpdateUser() {
        var map = new HashMap<String, String>();
        map.put("name", "Arshak Arshak_Updated");
        map.put("gender", "Male");
        map.put("email", "arshak@gmail.com");
        map.put("status", "Active");
        JSONObject jsonObject = new JSONObject(map);
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .put("https://gorest.co.in/public-api/users/123").then().statusCode(200).log().all();
    }
}
