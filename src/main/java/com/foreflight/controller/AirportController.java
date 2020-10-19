package com.foreflight.controller;

import com.foreflight.dto.api.AirportResponse;
import com.foreflight.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/airport")
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/{faaCode}")
    public AirportResponse findWeather(@PathVariable(value = "faaCode") String faaCode) {
        return airportService.findAirport(faaCode);
    }
}
