package endpoints;

import pojo_classes.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserService {

    public static RequestSpecification requestSpec = given()
            .baseUri(Routes.BASE_URI)
            .contentType(ContentType.JSON);

    public static Response createUser(User userPayload){
    Response response =
            given().
                    spec(requestSpec).
                    body(userPayload).
            when().
                    post(Routes.POST_USER_ENDPOINT);
    return response;
    }

    public static Response getUser(String username){
    Response response =
           given().
                   spec(requestSpec).
                   pathParam("username", username).
           when().
                  get(Routes.GET_USER_ENDPOINT);
    return response;
    }

    public static Response updateUser(String username, User payload){
    Response response =
           given().
                  spec(requestSpec).
                  pathParam("username", username).
                  body(payload).
           when().
                  put(Routes.UPDATE_USER_ENDPOINT);
    return response;
    }

    public static Response deleteUser(String username){
    Response response =
           given().
                   spec(requestSpec).
                   pathParam("username", username).
                   when().
                   delete(Routes.DELETE_USER_ENDPOINT);
    return response;
    }
    public static Response loginUser(String username, String password){
        Response response =
                given().
                        spec(requestSpec).
                        queryParam("username", username).
                        queryParam("password", password).
                when().
                        get(Routes.LOGIN_USER_ENDPOINT);
        return response;
    }
}
