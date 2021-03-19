package loadData;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DataLoader {
    public StringBuilder loadData(String site) {

        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(site);

            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();

            InputStreamReader reader = new InputStreamReader(is, "windows-1251");
            BufferedReader br = new BufferedReader(reader);

            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException exception) {
            System.out.println("Ошибка " + exception.getMessage());
        }


        return content;
    }
}
