package BasePackage;
import DataPackage.SearchFullModel;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ApiRequestClass extends BaseClass {


    @Description("Get response body to spesific movie imdb id or movie title. PS: If you want to get movie body with title just get last film")
    public Response requestDataID(String imdbID)
    {
        Response response = given().
                param(SearchFullModel.API_KEY.getData(), "c1731d23").
                param(SearchFullModel.IMDB_ID.getData(), imdbID).
                param(SearchFullModel.FILM_NAME.getData(), "").
                param(SearchFullModel.TYPE.getData(), "").
                param(SearchFullModel.YEAR.getData(), "").
                param(SearchFullModel.PLOT.getData(), "short").
                param(SearchFullModel.DATA_TYPE.getData(), "json").
                param(SearchFullModel.CALLBACK.getData(), "").
                param(SearchFullModel.APIVERSION.getData(), "1")
                .contentType(JSON)
                .when().get(baseURI)
                .then()
                .assertThat()
                .extract().response();
        return response;
    }

    @Description("Get Body with movie title for search")
    public Response requestSearch(String searchData){
      Response response= given().
                 param(SearchFullModel.API_KEY.getData(), "c1731d23")
                .param(SearchFullModel.TYPE.getData(), "movie")
                .param(SearchFullModel.DATA_TYPE.getData(), "json")
                .param(SearchFullModel.SEARCH_VALUE.getData(),searchData)
                .param(SearchFullModel.PAGE.getData(), "1")
                .param(SearchFullModel.CALLBACK.getData(), "")
                .param(SearchFullModel.APIVERSION.getData(), "1")
                .contentType(JSON)
                .when().get(baseURI).then().statusCode(200).assertThat().extract().response();
      return response;
    }

}
