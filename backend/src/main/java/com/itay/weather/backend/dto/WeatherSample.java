package com.itay.weather.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherSample {
    private String source;
    private Location location;
    private Timestamp time;
    private Double temperature;
    private Integer humidity;
}
