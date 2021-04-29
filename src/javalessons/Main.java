package javalessons;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Main.from_json_to_jackson_java();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void from_json_to_jackson_java() throws Exception {
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
        Pet[] pets = objectMapper.readValue(response.toString(), Pet[].class);
        List<Pet> petList = new ArrayList(Arrays.asList(pets));
        petList.forEach(x -> System.out.println("\n" + x.toString()));
    }
}
