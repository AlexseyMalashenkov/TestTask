package parse;

import dto.ExchangeDTO;
import dto.WeatherDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;

public class ParserDataWeather {
    public void parseWeather(String jsonString, int dayIndex) {
        ArrayList<WeatherDTO> weatherDTO = new ArrayList<>();


        JSONObject jsonObj = new JSONObject(jsonString);

        JSONObject s = jsonObj.getJSONObject("city");

        String city = jsonObj.getJSONObject("city").getString("name");
        String country = jsonObj.getJSONObject("city").getString("country");
        Integer id = jsonObj.getJSONObject("city").getInt("id");

        Double lon = jsonObj.getJSONObject("city").getJSONObject("coord").getDouble("lon");
        Double lat = jsonObj.getJSONObject("city").getJSONObject("coord").getDouble("lat");

        JSONArray weatherList = jsonObj.getJSONArray("list");
        Iterator iterator = weatherList.iterator();

        int i = 0;
        while (iterator.hasNext() && i < 5) {
            JSONObject item = weatherList.getJSONObject(i);

            JSONObject temp = item.getJSONObject("temp");
            Double day = temp.getDouble("day");
            Double night = temp.getDouble("night");
            Integer pressure = item.getInt("pressure");

            Integer date = item.getInt("dt");
            Instant instant = Instant.ofEpochSecond(date);

            System.out.println("day - " + day + " night - " + night + " pressure - " + pressure + " date - " + instant + " city - " + city + " country - " + country + " lon - " + lon + " lat - " + lat + " id - " + id);

            i++;
            iterator.next();
        }


    }
}
