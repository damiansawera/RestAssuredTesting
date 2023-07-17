package endpoints;

import pojo_classes.Pet;
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
    public static Response getPet(long petId){
        Response response =
                given().
                        spec(requestSpec).
                        pathParam("petId", petId).
                when().
                        get(Routes.GET_PET_ENDPOINT);
        return response;
    }

    public static Response updatePet(long id, Pet petPayload) {
        Response response =
                given().
                        spec(requestSpec).
                        queryParam("id", id).
                        body(petPayload).
                when().
                        put(Routes.PUT_PET_ENDPOINT);
        return response;
    }

    public static Response deletePet(long id) {
        Response response =
                given().
                        spec(requestSpec).
                        pathParam("petId", id).
                when().
                        delete(Routes.DELETE_PET_ENDPOINT);
        return response;
    }
}
