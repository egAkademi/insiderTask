import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EntegrasyonTesti {

    @Test
    public void validateStatusCode (){
        given()
                .baseUri("http://generator.swagger.io").
        when().
                get("/api/swagger.json")
        .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
