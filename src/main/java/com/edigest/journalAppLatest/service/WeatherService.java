package com.edigest.journalAppLatest.service;

import com.edigest.journalAppLatest.AppCache.AppCache;
import com.edigest.journalAppLatest.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private AppCache  appCache;
//    private static final String API="http://api.weatherapi.com/v1/current.json?key=API_KEY&q=CITY&aqi=no";

    @Autowired
    private RestTemplate restTemplate;
    public WeatherResponse getWeather(String city){
//        String finalAPI = String.format(
//                "http://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no",
//                apiKey, city
//        );
        System.out.println("AppCache contents: " + appCache.APP_CACHE);
        String finalAPI=appCache.APP_CACHE.get("weather_api").replace("<city>",city).replace("<apiKey>",apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
