package com.foreflight.openFeign;

import com.foreflight.dto.api.ReportResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "weather", url = "https://api.foreflight.com/weather/")
@RequestMapping("/report")
public interface WeatherFeign {

    @GetMapping("/{airport}")
    ReportResponse findWeather(
            @PathVariable("airport") String airport,
            @RequestHeader("Authorization") String header
    );
}
