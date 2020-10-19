package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ForeCastDto {
    private String text;
    private String ident;
    private Date dateIssued;
    private PeriodDto period;
    private double lat;
    private double lon;
    private double elevationFt;
    private List<ConditionsDto> conditions;
}
