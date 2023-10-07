import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri("https://qa.koel.app")
                .build();
    }

    @Test
    public void checkLoginTest() {
        int statusCode = given(getRequestSpecification()).body("{email:\"demo@class.com\",password:\"te$t$tudent\"}")
                .post("/api/me").andReturn().statusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
