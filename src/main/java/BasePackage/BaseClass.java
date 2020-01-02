package BasePackage;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;

public class BaseClass {
     protected RequestSpecification requestSpecification;


    @Before

    public void Init() throws Exception {
        RestAssured.baseURI = "http://www.omdbapi.com/";
    }

    @After
    public void Teardown() {

    }

}
