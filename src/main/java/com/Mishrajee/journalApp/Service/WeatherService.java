package com.Mishrajee.journalApp.Service;

import com.Mishrajee.journalApp.ApiResponse.WeatherResponse;
import com.Mishrajee.journalApp.Cache.ApiCache;
import com.Mishrajee.journalApp.Constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


    private final RestTemplate restTemplate;


@Autowired
private RedisService redisService;

    private final ApiCache appCache;

    public WeatherService(RestTemplate restTemplate, ApiCache appCache) {
        this.restTemplate = restTemplate;
        this.appCache = appCache;
    }

    @Value("${weather.api.key}")
    private String apikey;


    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("Weather_of_" + city, WeatherResponse.class);
        if(weatherResponse!=null){
            return weatherResponse;
        }
        else {
            String finalApi = appCache.APP_CACHE.get("weather_api").replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apikey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body!=null){
                redisService.set("Weather_of_" + city,body,300l);
            }
            return body;
        }
    }
}

