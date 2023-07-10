package Endpoints;

import POJOclasses.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetService {
    public static RequestSpecification requestSpec = given()
            .baseUri(Routes.BASE_URI)
            .contentType(ContentType.JSON);

    public static Response createPet(Pet petPayload) {
        Response response =
                given().
                        spec(requestSpec).
                        body(petPayload).
                when().post(Routes.POST_PET_ENDPOINT);
        return response;
    }

}
