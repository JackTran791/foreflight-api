package com.foreflight.dto.main;

import com.foreflight.dto.api.RunWayDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Report {
    private String faaCode;
    private String name;
    private List<RunWayDto> runways;
    private double latitude;
    private double longitude;
    private Weather weather;
    private ForeCast forecast;
}

