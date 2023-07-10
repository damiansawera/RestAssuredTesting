package Endpoints;

import POJOclasses.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserEndpoints {

    public static RequestSpecification requestSpec = given()
            .baseUri(Routes.BASE_URI)
            .contentType(ContentType.JSON);

    public static Response createUser(User payload){
    Response response =
            given().
                    spec(requestSpec).
                    body(payload).
            when().
                    post(Routes.POST_ENDPOINT);
    return response;
    }

    public static Response getUser(String username){
    Response response =
           given().
                   spec(requestSpec).
                   pathParam("username", username).
           when().
                  get(Routes.GET_ENDPOINT);
    return response;
    }

    public static Response updateUser(String username, User payload){
    Response response =
           given().
                  spec(requestSpec).
                  pathParam("username", username).
                  body(payload).
           when().
                  put(Routes.UPDATE_ENDPOINT);
    return response;
    }

    public static Response deleteUser(String username){
    Response response =
           given().
                   spec(requestSpec).
                   pathParam("username", username).
                   when().
                   delete(Routes.DELETE_ENDPOINT);
    return response;
    }
}
