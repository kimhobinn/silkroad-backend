package com.example.silkroad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoadMapResponse {
    String occupation;
    String title;
    Map<String, List<String>> content = new HashMap<>();
    Map<String, List<String>> additionalData = new HashMap<>();
    List<String> tip = new ArrayList<>();


    public void addContentBySection(String section, String data){
        content.computeIfAbsent(section, k -> new ArrayList<>()).add(data);
    }

    public void addAdditionalDataBySection(String section, String data){
        additionalData.computeIfAbsent(section, k -> new ArrayList<>()).add(data);
    }

    public void addTip(String data){
        tip.add(data);
    }
}
