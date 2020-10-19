package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class PeriodDto {
    private Date dateStart;
    private Date dateEnd;
}
