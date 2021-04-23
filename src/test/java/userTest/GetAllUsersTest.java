package userTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import model.etities.UserEntity;
import org.json.simple.JSONObject;
import org.junit.Test;
import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllUsersTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void getResponseBody() {

        Response response = given()
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when().get("https://gorest.co.in/public-api/users");
        if (response.getStatusCode() == 200) {
            List<JSONObject> data = response.then().extract().body().jsonPath().get("data");
            try {
                convertJsonDataToUserAndSave(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void convertJsonDataToUserAndSave(List<JSONObject> data) throws IOException, SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (JSONObject jsonObject : data) {
            UserEntity userEntity = objectMapper.readValue(String.valueOf(jsonObject), new TypeReference<List<UserEntity>>() {
            });
            userService.add(userEntity);
        }
//
//        for (int i = 0; i < data.size() - 1; i++) {
//            UserEntity userEntity = UserEntity.builder()
//                    .name((String) data.get(String.format("name[%s]", i)))
//                    .email((String) data.get(String.format("email[%s]", i)))
//                    .gender((String) data.get(String.format("gender[%s]", i)))
//                    .status((String) data.get(String.format("status[%s]", i)))
//                    .createdAt((LocalDateTime) data.get(String.format("created_at[%s]", i)))
//                    .updatedAt((LocalDateTime) data.get(String.format("updated_at[%s]", i)))
//                    .build();
//            userEntities.add(userEntity);
//        }
    }
}