package LetCode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class RestAssuredTest {
    @Test
    public void testGetRequest() {
        given()
            .baseUri("https://687e97dbefe65e5200871cdb.mockapi.io/api/v1")
        .when()
            .get("/users/2")
        .then().log().all();
    }

}
