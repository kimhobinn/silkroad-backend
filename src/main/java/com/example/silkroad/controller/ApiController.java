package com.example.silkroad.controller;

import com.example.silkroad.dto.RoadMap;
import com.example.silkroad.service.RoadMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    final RoadMapService roadMapService;

    @GetMapping("/occupation/{job-name}")
    public RoadMap occupation(@PathVariable(name = "job-name") String name) throws IOException {
        //TODO: server to server 통신 후 객체 생성 및 반환 구현. 지금은 임시로 String 반환
        return roadMapService.getRoadMap();
    }
}
