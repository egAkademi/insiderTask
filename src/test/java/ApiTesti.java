import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTesti {

    @Test
    public void postOrderPositive() {
        String  x = "{\n" +
                "\t\"id\":0,\n" +
                //"\t\"category\":\"test\",\n" +
                "\t\"name\":\"horse\",\n" +
                //"\t\"photoUrls\":\"\",\n" +
                //"\t\"tags\":\"\",\n" +
                "\t\"status\":\"available\"\n" +
                "}";
        RestAssured.baseURI = "https://petstore.swagger.io";
        given()//Yazılacak request’e başlamak için kullanılacak annotation’dır.
                .header("Content-Type","application/json")
                .body(x) //request, bir body gerektiriyor ise kullanılır, burada biz Inputs sınıfımızda oluşturduğumuz String çağırdık ve body bilgisini buradan aldı.
                .log().all() //Gönderilen request’i loglamak ve kod çalıştığında console’a yazdırmak için kullanılır.
                .when() // post, put, get, delete methodlarından önce kullanılarak, given’da verilen parametrelerin ne zaman kullanılacağını belirtir. Zorunlu değildir.
                .post("/v2/pet") //Request’imizde hangi method kullanılacağı belirtilir. Bu örnekte POST methodu’unu kullanıyoruz çünkü bir veri girişi yapmaya çalışıyoruz. Bu method’un içine ilgili API’ın resource’ı yazılır.
                .then()//response kısmında ne aksiyon alınacağına dair kullanılan annotation’dır.
                .log().all()//response’umuzu loglamak ve console’a yazdırmak için kullanılır
                .assertThat()
                .body("name",equalTo("horse"));
    }

    @Test
    public void postOrderNegative() {
        String  x = "{\n" +
                "\t\"id\":0,\n" +
                //"\t\"category\":\"test\",\n" +
                "\t\"name\":\"testPost\",\n" +
                //"\t\"photoUrls\":\"\",\n" +
                //"\t\"tags\":\"\",\n" +
                "\t\"status\":\"available\"\n" +
                "}";
        RestAssured.baseURI = "https://petstore.swagger.io";
        given()//Yazılacak request’e başlamak için kullanılacak annotation’dır.
                .header("Content-Type","application/json")
                .body(x) //request, bir body gerektiriyor ise kullanılır, burada biz Inputs sınıfımızda oluşturduğumuz String çağırdık ve body bilgisini buradan aldı.
                .log().all() //Gönderilen request’i loglamak ve kod çalıştığında console’a yazdırmak için kullanılır.
                .when() // post, put, get, delete methodlarından önce kullanılarak, given’da verilen parametrelerin ne zaman kullanılacağını belirtir. Zorunlu değildir.
                .post("/v2/pet") //Request’imizde hangi method kullanılacağı belirtilir. Bu örnekte POST methodu’unu kullanıyoruz çünkü bir veri girişi yapmaya çalışıyoruz. Bu method’un içine ilgili API’ın resource’ı yazılır.
                .then()//response kısmında ne aksiyon alınacağına dair kullanılan annotation’dır.
                .log().all()//response’umuzu loglamak ve console’a yazdırmak için kullanılır
                .assertThat()
                .body("id",equalTo(1),"name",equalTo("testPost"));
    }

    @Test
    public void putOrderPositive() {
        String  x = "{\n" +
                "\t\"id\":9223372000001082435,\n" +
                //"\t\"category\":\"test\",\n" +
                "\t\"name\":\"cat\",\n" +
                //"\t\"photoUrls\":\"\",\n" +
                //"\t\"tags\":\"\",\n" +
                "\t\"status\":\"available\"\n" +
                "}";
        RestAssured.baseURI = "https://petstore.swagger.io";
        given()
                .header("Content-Type","application/json")
                .body(x)
                .log().all()
                .when()
                .put("/v2/pet")
                .then()
                .log().all()
                .assertThat()
                .body("name",equalTo("cat"));
    }

    @Test
    public void putOrderNegative() {
        String  x = "{\n" +
                "\t\"id\":0,\n" +
                //"\t\"category\":\"test\",\n" +
                "\t\"name\":\"test\",\n" +
                //"\t\"photoUrls\":\"\",\n" +
                //"\t\"tags\":\"\",\n" +
                "\t\"status\":\"available\"\n" +
                "}";
        RestAssured.baseURI = "https://petstore.swagger.io";
        given()
                .header("Content-Type","application/json")
                .body(x)
                .log().all()
                .when()
                .put("/v2/pet")
                .then()
                .log().all()
                .assertThat()
                .body("id",equalTo(0),"name",equalTo("test1"));
    }

    @Test
    public void getOrderPostive() {
        given()
                .baseUri("https://petstore.swagger.io").
                when().
                get("/v2/pet/9223372000001082435")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("name",equalTo("cat"));
    }

    @Test
    public void getOrderNegative() {
        given()
                .baseUri("https://petstore.swagger.io").
                when().
                get("/v2/pet/9223372000001082435")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("name",equalTo("horse"));
    }

    @Test
    public void postOrder() {
        String  x = "{\n" +
                "\t\"id\":0,\n" +
                //"\t\"category\":\"test\",\n" +
                "\t\"name\":\"wolf\",\n" +
                //"\t\"photoUrls\":\"\",\n" +
                //"\t\"tags\":\"\",\n" +
                "\t\"status\":\"available\"\n" +
                "}";
        RestAssured.baseURI = "https://petstore.swagger.io";
        given()//Yazılacak request’e başlamak için kullanılacak annotation’dır.
                .header("Content-Type","application/json")
                .body(x) //request, bir body gerektiriyor ise kullanılır, burada biz Inputs sınıfımızda oluşturduğumuz String çağırdık ve body bilgisini buradan aldı.
                .log().all() //Gönderilen request’i loglamak ve kod çalıştığında console’a yazdırmak için kullanılır.
                .when() // post, put, get, delete methodlarından önce kullanılarak, given’da verilen parametrelerin ne zaman kullanılacağını belirtir. Zorunlu değildir.
                .post("/v2/pet") //Request’imizde hangi method kullanılacağı belirtilir. Bu örnekte POST methodu’unu kullanıyoruz çünkü bir veri girişi yapmaya çalışıyoruz. Bu method’un içine ilgili API’ın resource’ı yazılır.
                .then()//response kısmında ne aksiyon alınacağına dair kullanılan annotation’dır.
                .log().all()//response’umuzu loglamak ve console’a yazdırmak için kullanılır
                .assertThat()
                .body("name",equalTo("wolf"));
    }

    @Test
    public void deleteOrderPositive() {
        String id = "9223372000001082544";
        given()
                .pathParam("id",id)
                .baseUri("https://petstore.swagger.io").
                when().
                delete("/v2/pet/{id}")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("message",equalTo(id));
    }

    @Test
    public void deleteOrderNegative() {
        String id = "9223372000001082544";
        given()
                .pathParam("id",id)
                .baseUri("https://petstore.swagger.io").
                when().
                delete("/v2/pet/{id}")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("message",equalTo(id));
    }
}
