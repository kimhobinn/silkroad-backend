package com.example.silkroad.controller;

import com.example.silkroad.dto.RoadMapRequest;
import com.example.silkroad.dto.RoadMapResponse;
import com.example.silkroad.service.RoadMapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    final RoadMapService roadMapService;

    @GetMapping("/occupation")
    public RoadMapResponse occupation(@Valid @ModelAttribute RoadMapRequest request, BindingResult bindingResult) {
        //TODO: server to server 통신 후 객체 생성 및 반환 구현. 지금은 임시로 String 반환
        //String roadMap = roadMapService.GenerateRoadMapFromPython(request);
        return roadMapService.convertStringToRoadMap("test");

    }
}
