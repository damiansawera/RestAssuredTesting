package Test;

import Endpoints.UserEndpoints;
import POJOclasses.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTests{

    Faker faker;
    User payload;

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
       Response response = UserEndpoints.createUser(payload);
       response.then().log().all();
       assertThat(200, equalTo(response.getStatusCode()));
    }

    @Test(priority = 2)
    public void testGetUser() {
        Response response = UserEndpoints.getUser(this.payload.getUsername());
        response.then().log().all();
        assertThat(200, equalTo(response.getStatusCode()));
    }

    @Test(priority = 3)
    public void testUpdateUser() {

        payload.setLastName(faker.name().lastName());
        payload.setFirstName(faker.name().firstName());

        Response response = UserEndpoints.updateUser(this.payload.getUsername(), payload);
        response.then().log().all();
        assertThat(200, equalTo(response.getStatusCode()));
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        Response response = UserEndpoints.deleteUser(this.payload.getUsername());
        response.then().log().all();
        assertThat(200, equalTo(response.getStatusCode()));
    }
}
