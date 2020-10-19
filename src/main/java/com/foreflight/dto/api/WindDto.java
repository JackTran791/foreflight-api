package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindDto {
    private double speedKts;
    private int direction;
    private int from;
    private boolean variable;
}
