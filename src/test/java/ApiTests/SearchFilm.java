package ApiTests;
import BasePackage.ApiRequestClass;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;


public class SearchFilm extends ApiRequestClass {
    @Test
        @Description("Get Imdb ID with search value")
        public void getIDWithValue()
        {
            int exampleFilmIndex=1;
            String searchData= "Harry Potter";
            Response response = requestSearch(searchData);
            String imdbID = response.path("Search["+exampleFilmIndex+"].imdbID");
            System.out.println("Film's IMDB ID = " +imdbID);
            searchWithID(imdbID);
        }
    @Description("Check film response body with ImdbID ")
    private void searchWithID(String imdbID)
    {
        requestDataID(imdbID).then()
                .body("Title", equalTo("Harry Potter and the Sorcerer's Stone")).and()
                .body("Year",equalTo("2001")).and()
                .body("Released",equalTo("16 Nov 2001")).and()
                .statusCode(HttpStatus.SC_OK);
    }
    }


