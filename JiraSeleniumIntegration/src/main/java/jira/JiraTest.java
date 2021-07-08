package jira;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import javax.json.*;

public class JiraTest {
	
	static String username = "polidora2k";
	static String apiKey = "CJXHQLJv4Wi1aYyTyubCA31F";
	static String pass = "SsKu756h!,B";
	
	public static void main(String[] args){
		try {
            URL url = new URL("https://polidoraian.atlassian.net/rest/api/2/issue");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);

            String encodedData = getJSON_Body();
            System.out.println(encodedData);

            System.out.println(getJSON_Body());
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString("polidora2k@gmail.com:CJXHQLJv4Wi1aYyTyubCA31F".getBytes()));
            conn.setRequestProperty("Content-Type", "application/json");
            conn.getOutputStream().write(encodedData.getBytes());

            try {
            	BufferedReader in = new BufferedReader(new InputStreamReader(
    					conn.getInputStream()));
    			String inputLine;
    			StringBuffer response = new StringBuffer();

    			while ((inputLine = in.readLine()) != null) {
    				System.out.println(inputLine);
    			}
    			in.close();

    			// print result
    			//System.out.println(response.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    private static String getJSON_Body() {
        JsonObject createIssue = Json.createObjectBuilder()
                .add("fields",
                        Json.createObjectBuilder().add("project",
                                Json.createObjectBuilder().add("key", "SIT"))
                                .add("summary", "Test issue 2")
                                .add("description", "Test Issue")
                                .add("issuetype",
                                        Json.createObjectBuilder().add("name", "Bug"))
                ).build();

        return createIssue.toString();
    }
}
//http://localhost:8090/jira