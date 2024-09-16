package com.itay.weather.processor.model;

import com.itay.weather.processor.dto.Location;
import com.itay.weather.processor.dto.WeatherSample;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherSampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String source;
    @Embedded
    private Location location;
    private Timestamp time;
    private Double temperature;
    private Integer humidity;

    public WeatherSampleModel(WeatherSample weatherSample){
        this.source = weatherSample.getSource();
        this.location = weatherSample.getLocation();
        this.time = weatherSample.getTime();
        this.temperature = weatherSample.getTemperature();
        this.humidity = weatherSample.getHumidity();
    }
}
