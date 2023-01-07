package com.example.weatherapi.controllers;

import com.example.weatherapi.openweather.OpenWeatherApiResponse;
import com.example.weatherapi.weather.GetWeatherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/weatherTest")
    public ResponseEntity getWeather(Double lat, Double lon) {
        if(lat == null  || lon == null)
        {
            return ResponseEntity.badRequest().body("Latitude and/or longitude should not be null");
        }

        try {
            String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric&appid=b1338136c02fa64eb70401276a03c23c", lat, lon);
            OpenWeatherApiResponse weather = restTemplate.getForObject(url, OpenWeatherApiResponse.class);
            var response = new GetWeatherResponse(
                    weather.getClouds().getAll(),
                    weather.getWeather()[0].getDescription(),
                    weather.getMain().getTemp(),
                    weather.getWind().getSpeed());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RestClientException e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
