package comporators;

import dto.WeatherDTO;

import java.util.Comparator;

public class ComparatorByPressure implements Comparator<WeatherDTO> {
    @Override
    public int compare(WeatherDTO o1, WeatherDTO o2) {
        ComparatorsInteger comparators = new ComparatorsInteger();

        int pressureCompare =  comparators.compare(o1.getPressureValue(), o2.getPressureValue());

        return pressureCompare;
    }
}
