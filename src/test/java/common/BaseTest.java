package common;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://gorest.co.in/";
    }
}
