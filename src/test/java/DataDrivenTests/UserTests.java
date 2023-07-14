package DataDrivenTests;

import Endpoints.UserService;
import POJOclasses.User;
import Utility.DataProviders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;

public class UserTests {

    private static final ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .contentType(ContentType.JSON);



    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String id, String username, String firstName, String lastName, String email, String password, String phone) {

        User userPayload = new User();

        userPayload.setId(Integer.parseInt(id));
        userPayload.setUsername(username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserService.createUser(userPayload);
        response.
                then().spec(responseSpec);

    }

    @Test(priority = 2, dataProvider = "Usernames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String username) {

        Response response = UserService.deleteUser(username);
        response.
                then().spec(responseSpec);
    }
}
