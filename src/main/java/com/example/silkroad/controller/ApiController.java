package com.example.silkroad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/occupation/{job-name}")
    public String occupation(@PathVariable(name = "job-name") String name){
        //TODO: server to server 통신 후 객체 생성 및 반환 구현. 지금은 임시로 String 반환
        return name;
    }
}
