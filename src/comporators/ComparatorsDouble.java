package comporators;

import java.util.Comparator;

public class ComparatorsDouble implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        return o2.compareTo(o1);
    }
}
