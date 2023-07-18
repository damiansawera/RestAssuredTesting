package endpoints;

import pojo_classes.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class PetService {

    static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }

    public static RequestSpecification requestSpec = given()
            .baseUri(getURL().getString("base_uri"))
            .contentType(ContentType.JSON);

    public static Response createPet(Pet petPayload) {
        String post_pet_url = getURL().getString("post_pet_endpoint");
        Response response =
                given().
                        spec(requestSpec).
                        body(petPayload).
                when().post(post_pet_url);
        return response;
    }
    public static Response getPet(long petId){
        String get_pet_url = getURL().getString("get_pet_endpoint");
        Response response =
                given().
                        spec(requestSpec).
                        pathParam("petId", petId).
                when().
                        get(get_pet_url);
        return response;
    }

    public static Response updatePet(long id, Pet petPayload) {
        String put_pet_endpoint = getURL().getString("put_pet_endpoint");
        Response response =
                given().
                        spec(requestSpec).
                        queryParam("id", id).
                        body(petPayload).
                when().
                        put(put_pet_endpoint);
        return response;
    }

    public static Response deletePet(long id) {
        String delete_pet_url = getURL().getString("delete_pet_endpoint");
        Response response =
                given().
                        spec(requestSpec).
                        pathParam("petId", id).
                when().
                        delete(delete_pet_url);
        return response;
    }
}
