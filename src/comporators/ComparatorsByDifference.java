package comporators;

import dto.WeatherDTO;

import java.util.Comparator;

public class ComparatorsByDifference implements Comparator<WeatherDTO> {
    @Override
    public int compare(WeatherDTO o1, WeatherDTO o2) {
        ComparatorsDouble comparators = new ComparatorsDouble();

        int pressureCompare =  comparators.compare((o2.getTemperatureDay() - o2.getTemperatureNight()), (o1.getTemperatureDay() - o1.getTemperatureNight()));

        return pressureCompare;
    }
}
