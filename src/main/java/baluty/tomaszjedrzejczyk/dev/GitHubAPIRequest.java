package baluty.tomaszjedrzejczyk.dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubAPIRequest {
    private static void sendGetRequest() {
        try {
            URL url = new URL("https://api.github.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set headers if needed (e.g., authentication token)
            connection.setRequestProperty("User-Agent", "Java-App"); // Set a user-agent

            int responseCode = connection.getResponseCode();
            System.out.println("Sending 'GET' request to GitHub API");
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response Body:");
            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
