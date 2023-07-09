package Test;

import Endpoints.UserEndpoints;
import POJOclasses.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTests{

    Faker faker;
    User payload;

    @BeforeMethod
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

    @Test
    public void testPostUser(){
       Response response = UserEndpoints.createUser(payload);
       assertThat(200, equalTo(response.getStatusCode()));
    }
}
