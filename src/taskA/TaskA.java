package taskA;

import loadData.DataLoader;
import parse.ParserDataWeather;

public class TaskA {
    public static void main(String[] args) {
        loadData("http://api.openweathermap.org/data/2.5/forecast/daily?q=Minsk&appid=995228a05aeffd24aed504ac7cfa3b21&units=metric&lang=ru");
    }

    private static String loadData(String url) {
        DataLoader dataLoader = new DataLoader();

        String json = dataLoader.loadData(url);

        ParserDataWeather parserDataWeather = new ParserDataWeather();
        parserDataWeather.parseWeather(json, 0);

        return json;
    }
}
