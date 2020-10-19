package com.foreflight.service;

import com.foreflight.configuration.ForeFlightConfig;
import com.foreflight.dto.api.AirportResponse;
import com.foreflight.openFeign.AirportFeign;
import com.foreflight.utils.GenerateBasicAuth;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AirportService {
    private final AirportFeign airportFeign;
    private final ForeFlightConfig foreFlightConfig;
    private final GenerateBasicAuth generateBasicAuth;

    public AirportResponse findAirport(String faaCode) {
        log.debug("Calling AirportFeign.findWeather");

        return airportFeign.findAirport(faaCode,
                generateBasicAuth.generate(foreFlightConfig.getUsername() , foreFlightConfig.getPassword()));
    }
}
