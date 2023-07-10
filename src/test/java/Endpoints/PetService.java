package Endpoints;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetService {
    public static RequestSpecification requestSpec = given()
            .baseUri(Routes.BASE_URI)
            .contentType(ContentType.JSON);
}
