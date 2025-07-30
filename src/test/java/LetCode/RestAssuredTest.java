package LetCode;

import groovy.json.JsonSlurper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {
    @Test(priority = 1)
    public void testGetRequest() {
        Response response = given()
                .baseUri("https://687e97dbefe65e5200871cdb.mockapi.io/api/v1").log().ifValidationFails()
                .when()
                .get("/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", hasItem("Carlton Cummings"),
                        "name", hasItems("Leanne Graham", "Ervin Howell")

                        , "[0].name", is(equalTo("Leanne Graham")), "createdAt",
                        everyItem(startsWith("2025"))).log().ifError().extract().response();
        String name = response.jsonPath().getString("[0].name");
        String name1 = JsonPath.from(response.asString()).getString("[0].name");
        System.out.println("test: " + name);
        System.out.println("test: " + name1);
        // also there's contains() method but this is tested if the count is correct and the order is correct
        // there's containsInAnyOrder() method but this is tested if the count is correct and the order is not important
        // empty() method is used to check if the list is empty
        //hasSize() method is used to check if the list has a specific size

        var jsonSlurper = new JsonSlurper();
        var object = jsonSlurper.parseText(given().baseUri("https://687e97dbefe65e5200871cdb.mockapi.io/api/v1")
                .when().get("/users/2").asString());
        System.out.println("test: " + object);
    }

    @Test(priority = 2)
    public void testPostRequest() {
        given()
                .baseUri("https://todo.qacart.com/api/v1").log().ifValidationFails()
                .when().get("/info/lectures").then().log().all().assertThat().statusCode(200);

    }
}
