package com.foreflight.service;

import com.foreflight.configuration.ForeFlightConfig;
import com.foreflight.dto.api.ReportResponse;
import com.foreflight.openFeign.WeatherFeign;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

@Slf4j
@Service
@AllArgsConstructor
public class WeatherService {
    private final WeatherFeign weatherFeign;
    private final ForeFlightConfig foreFlightConfig;

    public ReportResponse findWeather(String airport) {
        log.debug("Calling WeatherFeign.findWeather");

        byte[] encodedBytes = Base64Utils.encode((foreFlightConfig.getUsername() + ":" + foreFlightConfig.getPassword()).getBytes());
        String authHeader = "Basic " + new String(encodedBytes);

        return weatherFeign.findWeather(airport, authHeader);
    }
}
