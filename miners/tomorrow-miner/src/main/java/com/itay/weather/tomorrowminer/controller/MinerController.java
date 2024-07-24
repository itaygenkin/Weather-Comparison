package com.itay.weather.tomorrowminer.controller;

import com.itay.weather.tomorrowminer.dto.WeatherDataDto;
import com.itay.weather.tomorrowminer.producer.MinerProducer;
import com.itay.weather.tomorrowminer.service.MinerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tomorrow")
public class MinerController {

    private final MinerService minerService;
    private final MinerProducer minerProducer;

    public MinerController(MinerService minerService, MinerProducer minerProducer) {
        this.minerService = minerService;
        this.minerProducer = minerProducer;
    }

    @GetMapping
    public ResponseEntity<Void> fetchData() {
        System.out.println("Fetching data");
        try {
            WeatherDataDto data = minerService.fetchAndSendData();
            minerProducer.sendDataToKafka(data);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
