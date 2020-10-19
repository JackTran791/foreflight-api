package com.foreflight.service;

import com.foreflight.configuration.ForeFlightConfig;
import com.foreflight.dto.api.AirportResponse;
import com.foreflight.dto.api.ConditionsDto;
import com.foreflight.dto.api.ReportResponse;
import com.foreflight.dto.main.Conditions;
import com.foreflight.dto.main.ForeCast;
import com.foreflight.dto.main.Report;
import com.foreflight.dto.main.Weather;
import com.foreflight.openFeign.AirportFeign;
import com.foreflight.openFeign.WeatherFeign;
import com.foreflight.utils.GenerateBasicAuth;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@AllArgsConstructor
public class ReportService {
    private final AirportFeign airportFeign;
    private final WeatherFeign weatherFeign;
    private final ForeFlightConfig foreFlightConfig;
    private final ModelMapper modelMapper;
    private final GenerateBasicAuth generateBasicAuth;

    public Report generateReport(String faaCode) {
        log.debug("Calling AirportFeign");
        AirportResponse airportResponse = airportFeign.findAirport(faaCode,
                generateBasicAuth.generate(foreFlightConfig.getUsername(), foreFlightConfig.getPassword()));
        ReportResponse reportResponse = weatherFeign.findWeather(faaCode,
                generateBasicAuth.generate(foreFlightConfig.getUsername(), foreFlightConfig.getPassword()));
        Report report = new Report();
        Weather weather = modelMapper.map(reportResponse, Weather.class);
        List<ConditionsDto> conditions = reportResponse.getReport().getForecast().getConditions();
        List<Conditions> temp = IntStream.range(0, conditions.size())
                .filter(i -> i == 2 || i == 3)
                .mapToObj(i -> modelMapper.map(conditions.get(i), Conditions.class))
                .collect(Collectors.toList());

        ForeCast foreCast = new ForeCast();
        foreCast.setConditions(temp);

        report.setForecast(foreCast);
        report.setFaaCode(airportResponse.getFaaCode());
        report.setName(airportResponse.getName());
        report.setRunways(airportResponse.getRunways());
        report.setLatitude(airportResponse.getLatitude());
        report.setLongitude(airportResponse.getLongitude());
        report.setWeather(weather);
        return  report;
    }
}
