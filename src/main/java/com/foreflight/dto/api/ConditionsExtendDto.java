package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConditionsExtendDto extends ConditionsDto {
    private String ident;
    private  double tempC;
    private double dewpointC;
    private double pressureHg;
    private int densityAltitudeFt;
}
