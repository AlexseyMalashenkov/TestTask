package loadData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class DataLoader {
    public String loadData(String site) {

        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(site);

            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();

            InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(reader);

            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException exception) {
            System.out.println("Ошибка " + exception.getMessage());
        }


        return content.toString();
    }
}
