package com.edigest.journalAppLatest.service;

import com.edigest.journalAppLatest.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apiKey="79f4b26b22df4390a26142847262502";

    private static final String API="http://api.weatherapi.com/v1/current.json?key=API_KEY&q=CITY&aqi=no";
    @Autowired
    private RestTemplate restTemplate;
    public WeatherResponse getWeather(String city){
        String finalAPI = String.format(
                "http://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no",
                apiKey, city
        );
//        String finalAPI=API.replace("CITY",city).replace("key",API_KEY);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
