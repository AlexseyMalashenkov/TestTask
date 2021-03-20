package dto;

public class WeatherDTO {
    private String name;
    private String country;
    private String timezone;
    private String locationAltitude;
    private String locationLatitude;
    private String locationLongitude;
    private String time;
    private String temperatureDay;
    private String temperatureNight;
    private String pressureValue;
    private String pressureUnit;

    public WeatherDTO(String name, String country, String timezone, String locationAltitude, String locationLatitude, String locationLongitude, String time, String temperatureDay, String temperatureNight, String pressureValue, String pressureUnit) {
        this.name = name;
        this.country = country;
        this.timezone = timezone;
        this.locationAltitude = locationAltitude;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.time = time;
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.pressureValue = pressureValue;
        this.pressureUnit = pressureUnit;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLocationAltitude() {
        return locationAltitude;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getTime() {
        return time;
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

    public String getPressureUnit() {
        return pressureUnit;
    }
}
