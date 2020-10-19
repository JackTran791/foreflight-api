package com.foreflight.dto.main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private  double tempC;
    private int relativeHumidity;
    private double distanceSm;
    private double speedKts;
    private int direction;
}
