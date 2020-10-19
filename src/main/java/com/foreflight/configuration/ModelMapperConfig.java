package com.foreflight.configuration;

import com.foreflight.dto.api.AirportResponse;
import com.foreflight.dto.api.ConditionsDto;
import com.foreflight.dto.api.ReportResponse;
import com.foreflight.dto.main.Conditions;
import com.foreflight.dto.main.Report;
import com.foreflight.dto.main.Weather;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(AirportResponse.class, Report.class)
                .addMapping(AirportResponse::getFaaCode, Report::setFaaCode)
                .addMapping(AirportResponse::getName, Report::setName)
                .addMapping(AirportResponse::getLatitude, Report::setLatitude)
                .addMapping(AirportResponse::getLongitude, Report::setLongitude)
                .addMapping(AirportResponse::getRunways, Report::setRunways);

        modelMapper.createTypeMap(ReportResponse.class, Weather.class)
                .addMapping(res -> res.getReport().getConditions().getTempC(), Weather::setTempC)
                .addMapping(res -> res.getReport().getConditions().getRelativeHumidity(), Weather::setRelativeHumidity)
                .addMapping(res -> res.getReport().getConditions().getVisibility().getDistanceSm(), Weather::setDistanceSm)
                .addMapping(res -> res.getReport().getConditions().getWind().getSpeedKts(), Weather::setSpeedKts)
                .addMapping(res -> res.getReport().getConditions().getWind().getDirection(), Weather::setDirection);

        modelMapper.createTypeMap(ConditionsDto.class, Conditions.class)
                .addMapping(res -> res.getPeriod().getDateStart(), Conditions::setDateStart)
                .addMapping(res -> res.getWind().getSpeedKts(), Conditions::setSpeedKts)
                .addMapping(res -> res.getWind().getDirection(), Conditions::setDirection);

        return modelMapper;
    }
}
