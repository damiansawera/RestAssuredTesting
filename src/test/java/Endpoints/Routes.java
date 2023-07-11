package Endpoints;

public class Routes {
    public static final String BASE_URI = "https://petstore.swagger.io/v2";

    //User endpoints
    public static final String POST_USER_ENDPOINT = "/user/";
    public static final String GET_USER_ENDPOINT = "/user/{username}";
    public static final String UPDATE_USER_ENDPOINT = "/user/{username}";
    public static final String DELETE_USER_ENDPOINT = "/user/{username}";
    public static final String LOGIN_USER_ENDPOINT = "/user/login";

    // Pet endpoints

    public static final String POST_PET_ENDPOINT = "/pet";
    public static final String GET_PET_ENDPOINT = "/pet/{petId}";
    public static final String PUT_PET_ENDPOINT = "/pet";
    public static final String DELETE_PET_ENDPOINT = "pet/{petId}";
}
