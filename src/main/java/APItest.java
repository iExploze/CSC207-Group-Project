import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

public class APItest {
    /*
    * curently this class is only used to access the api token from spotify if given the correct
    * client id and client secret, IDK if I should put my here for now, but you could try
    *
    * some of the googling I did:
    * https://stackoverflow.com/questions/63876345/how-to-get-access-token-from-spotify-api-java
    * https://developer.spotify.com/documentation/web-api
    * also CHATGPT for any bugs and small fixes
    *
    * how to get a spotify client id and secret here:
    * https://developer.spotify.com/dashboard
    * */
    private static String TOKEN_URL = "https://accounts.spotify.com/api/token";
    private static String CLIENT_ID = "ba1c954f84174799aa5056753b71e538";
    private static String CLIENT_SECRET = "285ba86970874ee29c50f7a33a9a02c5";

    public static String getAccessToken() throws IOException {
        //URL Access Point
        URL url = new URL(TOKEN_URL);

        //Open http connection to URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);

        //setup post function and request headers
        String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(credentials.getBytes()));
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", basicAuth);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.getOutputStream().write("grant_type=client_credentials".getBytes());

        //get the access token
        Scanner scanner = new Scanner(connection.getInputStream());
        String AccessToken = scanner.next();

        return AccessToken;
    }
}
