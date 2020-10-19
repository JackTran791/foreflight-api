package com.foreflight.openFeign;

import com.foreflight.dto.api.AirportResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "airport", url = "https://api.foreflight.com/airports/")
@RequestMapping
public interface AirportFeign {

    @GetMapping("/{faaCode}")
    AirportResponse findAirport(
            @PathVariable("faaCode") String faaCode,
            @RequestHeader("Authorization") String header
    );

}
