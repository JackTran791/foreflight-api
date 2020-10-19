package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloudLayerDto {
    private String coverage;
    private double altitudeFt;
    private boolean ceiling;
}
