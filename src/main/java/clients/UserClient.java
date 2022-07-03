package clients;

import models.User;

public class UserClient extends RestAssuredClient{
    private final String AUTH = "/auth";
    private final String CREATE_USER = AUTH + "/register";
    private final String USER = AUTH + "/user";

    public String create(User user) {
        return reqSpec
                .body(user)
                .when()
                .post(CREATE_USER)
                .then().log().all()
                .extract()
                .path("accessToken");
    }

    public void delete(String accessToken){
        reqSpecWithoutHeaders
                .header("Authorization", accessToken)
                .when()
                .delete(USER);
    }
}
