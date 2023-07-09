package Endpoints;

import POJOclasses.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoints {

    public static Response createUser(User payload){
    Response response =
            given().
                    contentType(ContentType.JSON).
                    accept(ContentType.JSON).
                    body(payload).
            when().
                    post(Routes.POST_URL);
    return response;
    }

    public static Response getUser(String username){
    Response response =
           given().
                   pathParam("username", username).
           when().
                  get(Routes.GET_URL);
    return response;
    }

    public static Response updateUser(String username, User payload){
    Response response =
           given().
                  contentType(ContentType.JSON).
                  accept(ContentType.JSON).
                  pathParam("username", username).
                  body(payload).
           when().
                  put(Routes.UPDATE_URL);
    return response;
    }

    public static Response deleteUser(String username){
    Response response =
           given().
                   pathParam("username", username).
                   when().
                   delete(Routes.DELETE_URL);
    return response;
    }
}
