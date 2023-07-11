package Tests;

import Endpoints.PetService;
import POJOclasses.Pet;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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
    Pet.Category category = new Pet.Category();
    category.setId(faker.number().numberBetween(1, 99999));
    category.setName(faker.name().name());
    Pet.Tag tag = new Pet.Tag();
    tag.setId(faker.number().numberBetween(1, 99999));
    tag.setName(faker.name().name());

    petPayload.setId(faker.idNumber().hashCode());
    petPayload.setCategory(category);
    petPayload.setTags(List.of(tag));
    petPayload.setName(faker.name().name());
    petPayload.setPhotoUrls(List.of(faker.internet().url()));
    petPayload.setStatus(faker.random().nextInt(2) == 0 ? "available" : "unavailable");
    }

    @Test (priority = 1)
    public void testCreatePet() {
        Response response = PetService.createPet(petPayload);
        response.then().
                spec(responseSpec).
                log().all();
    }
    @Test(priority = 2)
    public void testGetPet() {
        Response response = PetService.getPet(this.petPayload.getId());
        response.then().
                    spec(responseSpec).
                    log().all();

    }
    @Test(priority = 3)
    public void testUpdatePet() {
        petPayload.setName(faker.name().name());
        petPayload.setPhotoUrls(List.of(faker.internet().url()));
        Response response = PetService.updatePet(this.petPayload.getId(), this.petPayload);
        response.then().
                spec(responseSpec).
                log().all();
    }
    @Test(priority = 4)
    public void testDeletePet() {
        Response response = PetService.deletePet(this.petPayload.getId());
        response.then().
                spec(responseSpec).
                log().all();
    }
}
