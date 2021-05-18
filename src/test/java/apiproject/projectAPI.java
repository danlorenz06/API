package apiproject;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class projectAPI {

    @Test
    public void Post() {
        JSONObject P = new JSONObject();

        P.put("name", "Dan");
        P.put("job", "Chef");

        System.out.println(P.toJSONString());

        given().
                body(P.toJSONString()).
        when().
                post ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }

    @Test
    public void Patch() {
        JSONObject P = new JSONObject();

        P.put("name", "Lilly");
        P.put("job", "Head Chef");

        System.out.println(P.toJSONString());

        given().
                body(P.toJSONString()).
        when().
                patch ("https://reqres.in/api/users/2").
        then().
            statusCode(200);
    }

    @Test
    public void Get() {

        when().
                get ("https://reqres.in/api/unknown/2").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void testing4delete() {

        when().
                delete ("https://reqres.in/api/users/2").
        then().
            statusCode(204).log().all();
    }

}
