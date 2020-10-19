package com.foreflight.dto.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportDto {
    private ConditionsExtendDto conditions;
    private ForeCastDto forecast;
}
