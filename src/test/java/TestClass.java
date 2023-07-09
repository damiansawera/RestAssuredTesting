import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestClass {

@Test
public void getTest(){
    String endpoint = "https://reqres.in/api/register/23";
    String body =       """
            {
                "email": "eve.holt@reqres.in",
                "password": "pistol"
            }
                        """;
        given().body(body).
        when().post(endpoint);
    }
}
