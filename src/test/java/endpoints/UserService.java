package endpoints;

import pojo_classes.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserService {
    static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }
    public static RequestSpecification requestSpec = given()
            .baseUri(getURL().getString("base_uri"))
            .contentType(ContentType.JSON);

    public static Response createUser(User userPayload){
        String post_user_endpoint = getURL().getString("post_user_endpoint");

        Response response =
            given().
                    spec(requestSpec).
                    body(userPayload).
            when().
                    post(post_user_endpoint);
    return response;
    }

    public static Response getUser(String username){
        String get_user_endpoint = getURL().getString("get_user_endpoint");
    Response response =
           given().
                   spec(requestSpec).
                   pathParam("username", username).
           when().
                  get(get_user_endpoint);
    return response;
    }

    public static Response updateUser(String username, User payload){
        String update_user_endpoint = getURL().getString("update_user_endpoint");
    Response response =
           given().
                  spec(requestSpec).
                  pathParam("username", username).
                  body(payload).
           when().
                  put(update_user_endpoint);
    return response;
    }

    public static Response deleteUser(String username){
        String delete_user_endpoint = getURL().getString("delete_user_endpoint");
        Response response =
           given().
                   spec(requestSpec).
                   pathParam("username", username).
                   when().
                   delete(delete_user_endpoint);
    return response;
    }
    public static Response loginUser(String username, String password){
        String login_user_endpoint = getURL().getString("login_user_endpoint");
        Response response =
                given().
                        spec(requestSpec).
                        queryParam("username", username).
                        queryParam("password", password).
                when().
                        get(login_user_endpoint);
        return response;
    }
}
