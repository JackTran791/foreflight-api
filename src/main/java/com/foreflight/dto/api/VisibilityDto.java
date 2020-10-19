package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisibilityDto {
    private double distanceSm;
    private int distanceQualifier;
    private double prevailingVisSm;
    private int prevailingVisDistanceQualifier;
}
