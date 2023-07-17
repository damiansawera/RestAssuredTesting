package tests;

import endpoints.UserService;
import pojo_classes.User;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTests{

    Faker faker;
    User userPayload;
    private static final ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .contentType(ContentType.JSON);

    @BeforeClass
    public void setUp() {

        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password(6, 12));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser() {
       Response response = UserService.createUser(userPayload);
       response.
               then().spec(responseSpec);
    }

    @Test(priority = 2)
    public void testGetUser() {
        Response response = UserService.getUser(this.userPayload.getUsername());
        response.
                then().spec(responseSpec);
    }

    @Test(priority = 3)
    public void testUpdateUser() {

        userPayload.setLastName(faker.name().lastName());
        userPayload.setFirstName(faker.name().firstName());

        Response response = UserService.updateUser(this.userPayload.getUsername(), userPayload);
        response.
                then().spec(responseSpec);
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        Response response = UserService.deleteUser(this.userPayload.getUsername());
        response.
                then().spec(responseSpec);
    }
    @Test(priority = 5)
    public void testLoginUser() {
        Response response = UserService.loginUser(this.userPayload.getUsername(), this.userPayload.getPassword());
        response.
                then().spec(responseSpec);
    }
}
