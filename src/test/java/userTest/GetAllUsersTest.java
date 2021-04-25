package userTest;

import common.BaseTest;
import io.restassured.response.Response;
import model.etities.UserEntity;
import org.junit.Test;
import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllUsersTest extends BaseTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void getResponseBody() {

        Response response = given()
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when().get("public-api/users");
        if (response.getStatusCode() == 200) {
           // JSONArray JSONResponseBody = new JSONArray(response.body().("data"));

            List<Object> data = response.then().extract().body().jsonPath().getList("data");
            try {
                convertJsonDataToUserAndSave(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void convertJsonDataToUserAndSave(List<Object> data) throws IOException, SQLException {
 //       ObjectMapper objectMapper = new ObjectMapper();
//        for (Object jsonObject : data) {
//            UserEntity userEntity = objectMapper.readValue(new JSONObject(jsonObject), new TypeReference<List<UserEntity>>() {
//            });
//        }
        for (Object jsonObject : data) {
            UserEntity userEntity = UserEntity.builder()
                    .userId((Integer) ((LinkedHashMap) jsonObject).get("id"))
                    .name((String) ((LinkedHashMap) jsonObject).get("name"))
                    .email((String) ((LinkedHashMap) jsonObject).get("email"))
                    .gender((String) ((LinkedHashMap) jsonObject).get("gender"))
                    .status((String) ((LinkedHashMap) jsonObject).get("status"))
                    .createdAt((String) ((LinkedHashMap) jsonObject).get("created_at"))
                    .updatedAt((String) ((LinkedHashMap) jsonObject).get("updated_at"))
                    .build();
            userService.add(userEntity);
        }
    }
}