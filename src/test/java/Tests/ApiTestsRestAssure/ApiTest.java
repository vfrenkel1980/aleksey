package Tests.ApiTestsRestAssure;

import Pages.BaseTest;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiTest extends BaseTest {


    RequestSpecification requestSpecification;

    @BeforeClass
    public void setupRequestSpecification()
    {
        requestSpecification = RestAssured.given()
                .baseUri(BaseApiUrl)
                .basePath("/api/users?page=2");
    }




    @Test
    public void Test1()
    {
        log.info("Api1 ");
//        Response response=get(requestSpecification);
//        System.out.println("Status of response is   "   +  response.getStatusCode());
//        System.out.println("Response is  "   +  response.asString());
//        System.out.println("Body is    "   +  response.getBody().asString());

                given()
                .get(BaseApiUrl +"/api/users?page=2")
                .then()
                .statusCode(200)
                 .body("data.id[1]",equalTo(8))
                        .body("data.first_name",hasItems("Michael","Lindsay"))
                        .log().all();

       // Assert.assertEquals(statusCode,201);



    }

    @Test
    public void Test2()
    {
        log.info("Api2 ");
        given()
                .get(BaseApiUrl +"/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("data.first_name",hasItems("Michael2","Lindsay2"))
                .log().all();



    }


}
