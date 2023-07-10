package Test;

import Endpoints.UserService;
import POJOclasses.User;
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
    User payload;
    private static final ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .contentType(ContentType.JSON);

    @BeforeClass
    public void setUp() {

        faker = new Faker();
        payload = new User();

        payload.setId(faker.idNumber().hashCode());
        payload.setUsername(faker.name().username());
        payload.setFirstName(faker.name().firstName());
        payload.setLastName(faker.name().lastName());
        payload.setEmail(faker.internet().emailAddress());
        payload.setPassword(faker.internet().password(6, 12));
        payload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser() {
       Response response = UserService.createUser(payload);
        System.out.println(payload.getUsername() +"\n"+ payload.getPassword());
       response.
               then().spec(responseSpec);
    }

    @Test(priority = 2)
    public void testGetUser() {
        Response response = UserService.getUser(this.payload.getUsername());
        response.
                then().spec(responseSpec);
    }

    @Test(priority = 3)
    public void testUpdateUser() {

        payload.setLastName(faker.name().lastName());
        payload.setFirstName(faker.name().firstName());

        Response response = UserService.updateUser(this.payload.getUsername(), payload);
        response.
                then().spec(responseSpec);
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        Response response = UserService.deleteUser(this.payload.getUsername());
        response.
                then().spec(responseSpec);
    }
    @Test(priority = 5)
    public void testLoginUser() {
        Response response = UserService.loginUser(this.payload.getUsername(), this.payload.getPassword());
        response.
                then().spec(responseSpec);
    }
}
