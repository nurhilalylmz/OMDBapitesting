package DataPackage;

public enum SearchFullModel {
    API_KEY("apikey"),
    SEARCH_VALUE("s"),
    FILM_NAME("t"),
    IMDB_ID("i"),
    TYPE("type"),
    YEAR("y"),
    PLOT("plot"),
    DATA_TYPE("r"),
    CALLBACK("callback"),
    APIVERSION("v"),
    PAGE("page");

    private String responseData;

    private SearchFullModel(String responseData) {
        this.responseData = responseData;
    }

    public String getData() {
        return this.responseData;
    }

}

