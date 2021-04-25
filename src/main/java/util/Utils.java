package util;

import model.etities.UserEntity;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.UUID;

public class Utils {
    public static JSONObject getJsonObject(UserEntity userEntity) {
        var map = new HashMap<String, String>();
        map.put("name", userEntity.getName());
        map.put("gender", userEntity.getGender());
        map.put("email", userEntity.getEmail());
        map.put("status", userEntity.getStatus());
        return new JSONObject(map);
    }

    public static String generateRandomEmail(){
        return String.format("%s_%s@gmail.com", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);

    }
}