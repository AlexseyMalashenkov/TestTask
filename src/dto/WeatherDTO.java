package dto;

public class WeatherDTO {
    private String locationLatitude;
    private String locationLongitude;
    private String locationAltitude;
    private double temperatureDay;
    private double temperatureNight;
    private int pressureValue;
    private String date;

    public WeatherDTO(String locationLatitude, String locationLongitude, String locationAltitude, double temperatureDay, double temperatureNight, int pressureValue, String date) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationAltitude = locationAltitude;
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.pressureValue = pressureValue;
        this.date = date;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getLocationAltitude() {
        return locationAltitude;
    }

    public double getTemperatureDay() {
        return temperatureDay;
    }

    public double getTemperatureNight() {
        return temperatureNight;
    }

    public int getPressureValue() {
        return pressureValue;
    }

    public String getDate() {
        return date;
    }
}
