package com.example.weatherapi.controllers;

import com.example.weatherapi.openweather.OpenWeatherApiResponse;
import com.example.weatherapi.weather.GetWeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/weatherTest")
    public GetWeatherResponse getWeather(Double lat, Double lon) {
        if(lat == null) {
            lat = 12.00;
        }
        if(lon == null){
            lon = 12.00;
        }
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric&appid=b1338136c02fa64eb70401276a03c23c", lat, lon);
        OpenWeatherApiResponse weather = restTemplate.getForObject(url, OpenWeatherApiResponse.class);
        return new GetWeatherResponse(
                weather.getClouds().getAll(),
                weather.getWeather()[0].getDescription(),
                weather.getMain().getTemp(),
                weather.getWind().getSpeed());
    }
}
