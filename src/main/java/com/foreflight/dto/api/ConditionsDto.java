package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ConditionsDto {
    private String text;
    private Date dateIssued;
    private double lat;
    private double lon;
    private double elevationFt;
    private int relativeHumidity;
    private String flightRules;
    private List<CloudLayerDto> cloudLayers;
    private List<CloudLayerDto> cloudLayersV2;
    private VisibilityDto visibility;
    private WindDto wind;
    private PeriodDto period;
}
