package userTest;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    @Test
    public void createUser() {
        var map = new HashMap<String, String>();
        map.put("name", "Arshak Arshak");
        map.put("gender", "Male");
        map.put("email", "arshak@gmail.com");
        map.put("status", "Active");
        JSONObject jsonObject = new JSONObject(map);
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 6b68ebdf11ed71fe0cf8537799dfaa5b5dafbdf11557175ee6063793afa0e280")
                .accept("application/json")
                .when()
                .body(jsonObject.toJSONString())
                .post("https://gorest.co.in/public-api/users");
        System.out.println(response.getBody().toString());
    }


    //"code":201,"meta":null,"data":{"id":1671,"name":"Arshak Arshak",
    // "email":"arshak@gmail.com","gender":"Male","status":"Active",
    // "created_at":"2021-04-23T19:09:11.483+05:30","updated_at":"2021-04-23T19:09:11.483+05:30"}}
}
