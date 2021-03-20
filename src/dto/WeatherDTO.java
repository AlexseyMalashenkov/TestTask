package dto;

public class WeatherDTO {
    private String name;
    private String country;
    private String locationLatitude;
    private String locationLongitude;
    private String temperatureDay;
    private String temperatureNight;
    private String pressureValue;

    public WeatherDTO(String name, String country, String locationLatitude, String locationLongitude, String temperatureDay, String temperatureNight, String pressureValue) {
        this.name = name;
        this.country = country;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.pressureValue = pressureValue;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getTemperatureDay() {
        return temperatureDay;
    }

    public String getTemperatureNight() {
        return temperatureNight;
    }

    public String getPressureValue() {
        return pressureValue;
    }
}
