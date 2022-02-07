package Tests.ApiTestsRestAssure;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class ApiTest {

    @Test
    public void Test1()
    {

        Response response=get("https://reqres.in/api/users?page=2");
        System.out.println("Status of response is   "   +  response.getStatusCode());
        System.out.println("Response is  "   +  response.asString());
        System.out.println("Body is    "   +  response.getBody().asString());


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);



    }




}
