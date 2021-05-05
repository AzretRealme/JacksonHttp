package myApp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
            Main main = new Main();
            main.sendGet();
        }

        private void sendGet() throws Exception {
        String url = "https://cat-fact.herokuapp.com/facts";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        ObjectMapper objectMapper = new ObjectMapper();
        Club[] pets = objectMapper.readValue(response.toString(), Club[].class);
        List<Club> petList = new ArrayList(Arrays.asList(pets));
        petList.forEach(x -> System.out.println("\n" + x.toString()));
    }
}
