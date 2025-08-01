package LetCode;

import groovy.json.JsonSlurper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {
    RequestSpecification req;
    RequestSpecification QACART;

    @BeforeClass
    public void beforeClass() {
        req = given().baseUri("https://687e97dbefe65e5200871cdb.mockapi.io/api/v1").log().all();
        QACART= given().baseUri("https://todo.qacart.com/api/v1").log().all();
    }

    @Test(priority = 1)
    public void testGetRequest() {
        Response response = given().spec(req).log().ifValidationFails()
                .when()
                .get("/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", hasItem("Carlton Cummings"),
                        "name", hasItems("Leanne Graham", "Ervin Howell")

                        , "[0].name", is(equalTo("Leanne Graham")), "createdAt",
                        everyItem(startsWith("2025"))).log().ifError().extract().response();
//        String name = response.jsonPath().getString("[0].name");
//        String name1 = JsonPath.from(response.asString()).getString("[0].name");
        // also there's contains() method but this is tested if the count is correct and the order is correct
        // there's containsInAnyOrder() method but this is tested if the count is correct and the order is not important
        // empty() method is used to check if the list is empty
        //hasSize() method is used to check if the list has a specific size

        var jsonSlurper = new JsonSlurper();
        var object = jsonSlurper.parseText(req
                .when().get("/users/2").asString());
        System.out.println("test: " + object);
    }

    @Test(priority = 2)
    public void testGetCourses() {
       JsonPath jsonPath = new JsonPath(QACART.when().get("/info/courses").asString());
       QACART
                .baseUri("https://todo.qacart.com/api/v1").log().ifValidationFails()
                .when().get("/info/courses").then().log().all().assertThat().statusCode(200);

    }

    @Test(priority = 3)
    public void testGetLectures() {
        Map<String, String> zz = new HashMap<>();

        given().spec(QACART).log().ifValidationFails().when().get("/info/lectures").then().log().all().assertThat().statusCode(200);

    }

    @Test(priority = 4)
    public void testPostLogin() {
        String body = "{\n" +
                "    \"email\":\"hatem@example.com\",\n" +
                "    \"password\":\"123456\"\n" +
                "}";
        File file = new File("src/test/resources/login.json");
        given().spec(QACART).contentType(ContentType.JSON)
                .baseUri("https://todo.qacart.com/api/v1").log().ifValidationFails()
                .when().post("/students/login").then().log().all().assertThat().statusCode(200);
// i have header to give authorization token
        // i have auth().oauth2(token)
    }
}
