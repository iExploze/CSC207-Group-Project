import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

public class getTrack {

    public static String getArtist(String token) throws IOException {
        URL url = new URL("https://api.spotify.com/v1/artists/6HvZYsbFfjnjFrWF950C9d");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty ("Authorization", "Bearer " + token);
        //conn.getOutputStream().write("grant_type=client_credentials".getBytes());

        Scanner scanner = new Scanner(conn.getInputStream());
        String ArtistID = scanner.next();
        return ArtistID;

    }
}
