package com.foreflight.dto.main;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ForeCast {
    List<Conditions> conditions;
}
