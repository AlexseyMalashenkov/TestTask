package taskA;

import loadData.DataLoader;

public class TaskA {
    public static void main(String[] args) {
        DataLoader loader = new DataLoader();

        StringBuilder content = loader.loadData("http://api.openweathermap.org/data/2.5/forecast/daily?q=Minsk&appid=995228a05aeffd24aed504ac7cfa3b21&mode=xml&units=metric");

        System.out.println(content);
    }
}
