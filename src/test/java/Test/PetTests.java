package Test;

import Endpoints.PetService;
import POJOclasses.Pet;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;

public class PetTests {

    private static final ResponseSpecification responseSpec = expect()
            .statusCode(200)
            .contentType(ContentType.JSON);
    Pet petPayload;
    Faker faker;

    @BeforeClass
    public void setUp() {
    faker = new Faker();
    petPayload = new Pet();

    petPayload.setId(faker.idNumber().hashCode());
    //TODO: fill up pet object with fake data
    }

    @Test
    public void testCreatePet() {
        Response response = PetService.createPet(petPayload);
        response.then()
                    .spec(responseSpec)
                .log().all();
    }


}
