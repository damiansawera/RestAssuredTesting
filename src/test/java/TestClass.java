import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestClass {

@Test
public void getTest(){
   String endpoint = "https://reqres.in/api/users?page=2";

        given().
        when().get(endpoint).
        then().log().body();

    }
}
