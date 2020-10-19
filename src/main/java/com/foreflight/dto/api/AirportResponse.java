package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AirportResponse {
    private String faaCode;
    private String name;
    private double latitude;
    private double longitude;
    private List<RunWayDto> runways;
}
