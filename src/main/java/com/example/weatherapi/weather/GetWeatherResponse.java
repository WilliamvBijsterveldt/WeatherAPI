package com.example.weatherapi.weather;

public class GetWeatherResponse {
    private int cloudiness;
    private String currentWeather;
    private double temperature;
    private double windSpeed;

    public GetWeatherResponse(int cloudiness, String currentWeather, double temperature, double windSpeed) {
        this.cloudiness = cloudiness;
        this.currentWeather = currentWeather;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
