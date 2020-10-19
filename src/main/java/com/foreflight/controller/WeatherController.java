package com.foreflight.controller;

import com.foreflight.dto.api.ReportResponse;
import com.foreflight.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{airport}")
    public ReportResponse findWeather(@PathVariable(value = "airport") String airport) {
        return weatherService.findWeather(airport);
    }
}
