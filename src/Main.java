import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String token = APItest.getAccessToken();
        System.out.println("Response: " + token);
    }
}
//Radnom text