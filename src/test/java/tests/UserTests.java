package tests;

import endpoints.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo_classes.User;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;

public class UserTests{

    Faker faker;
    User userPayload;
    public Logger logger;
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

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser() {
        logger.info("Creating user");
       Response response = UserService.createUser(userPayload);
       response.
               then().spec(responseSpec);
        logger.info("User is created");

    }

    @Test(priority = 2)
    public void testGetUser() {
        logger.info("Getting information about the user");

        Response response = UserService.getUser(this.userPayload.getUsername());
        response.
                then().spec(responseSpec);
        logger.info("Information Received");

    }

    @Test(priority = 3)
    public void testUpdateUser() {
        logger.info("Updating user");

        userPayload.setLastName(faker.name().lastName());
        userPayload.setFirstName(faker.name().firstName());

        Response response = UserService.updateUser(this.userPayload.getUsername(), userPayload);
        response.
                then().spec(responseSpec);
        logger.info("User updated");

    }

    @Test(priority = 4)
    public void testDeleteUser() {
        logger.info("Deleting user");

        Response response = UserService.deleteUser(this.userPayload.getUsername());
        response.
                then().spec(responseSpec);
        logger.info("User deleted");

    }
    @Test(priority = 5)
    public void testLoginUser() {
        logger.info("Trying to Log in");

        Response response = UserService.loginUser(this.userPayload.getUsername(), this.userPayload.getPassword());
        response.
                then().spec(responseSpec);
        logger.info("User Logged in");

    }
}
