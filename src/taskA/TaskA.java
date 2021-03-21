package taskA;

import comporators.ComparatorByPressure;
import comporators.ComparatorsByDifference;
import dto.WeatherDTO;
import parse.ParserDataWeather;

import java.util.ArrayList;

public class TaskA {
    public static void main(String[] args) {
        loadDTO("http://api.openweathermap.org/data/2.5/forecast/daily?q=Minsk&appid=995228a05aeffd24aed504ac7cfa3b21&mode=xml&units=metric&lang=ru");
    }

    private static void loadDTO(String url) {
        ParserDataWeather parserDataWeather = new ParserDataWeather();
        ArrayList<WeatherDTO> weathers = parserDataWeather.parseXMLWeather(url);

        maxPressure(weathers);

        minDifference(weathers);
    }

    private static void maxPressure(ArrayList<WeatherDTO> weathers) {
        ComparatorByPressure comparator = new ComparatorByPressure();
        weathers.sort(comparator);

        printMaxPressure(weathers.get(0));
    }

    private static void minDifference(ArrayList<WeatherDTO> weathers) {
        ComparatorsByDifference comparator = new ComparatorsByDifference();
        weathers.sort(comparator);

        printMinDifference(weathers.get(0));
    }

    private static void printMaxPressure(WeatherDTO weather) {
        System.out.println("Максимальное давление в городе с координатами " + weather.getLocationAltitude() + ":" + weather.getLocationLatitude() + ":" + weather.getLocationLongitude() + " будет равно " + weather.getPressureValue() + " и состоиться " + weather.getDate() + " числа.");
    }

    private static void printMinDifference(WeatherDTO weather) {
        System.out.println("День с минимальной разницей между ночной и утренней температурой в городе с координатами " + weather.getLocationAltitude() + ":" + weather.getLocationLatitude() + ":" + weather.getLocationLongitude() + " будет " + weather.getDate() + " числа и разница составит " + (weather.getTemperatureNight() - weather.getTemperatureDay()));
    }
}
