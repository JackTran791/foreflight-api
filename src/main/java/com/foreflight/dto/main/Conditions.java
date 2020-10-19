package com.foreflight.dto.main;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Conditions {
    private Date dateStart;
    private double speedKts;
    private int direction;
}
