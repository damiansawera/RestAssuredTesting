import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestClass {

@Test
public void getTest(){
<<<<<<< HEAD
    String endpoint = "https://reqres.in/api/register/23";
    String body =       """
            {
                "email": "eve.holt@reqres.in",
                "password": "pistol"
            }
                        """;
        given().body(body).
        when().post(endpoint).
=======
   String endpoint = "https://reqres.in/api/users?page=2";

        given().
        when().get(endpoint).
>>>>>>> eb6e7afda861f3962d97805a5ed8f73e8efd31b8
        then().log().body();

    }
}
