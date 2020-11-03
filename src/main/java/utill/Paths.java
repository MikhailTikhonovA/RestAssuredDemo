package utill;

public class Paths {

    public static final String PATH_LIST_PLACES = "apiservices/autosuggest/v1.0/";

    public static String getPath(String city, String country, String currency, String locale) {
        String result = country + "/" + currency + "/" + locale + "/?query=" + city;
        return result;
    }
}
