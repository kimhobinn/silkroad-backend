package com.example.silkroad.service;

import com.example.silkroad.dto.RoadMap;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service

public class RoadMapService {
    //TODO : text를 읽어오는 것이 아닌 Server to Server 연결 구현 예정
    BufferedReader fileReader = new BufferedReader( new FileReader("RoadMap_bard.txt"));
    List<String> textList = new ArrayList<>();

    public RoadMapService() throws IOException {
    }

    public RoadMap getRoadMap() throws IOException {
        String str, section = "";
        Status status = null;

        RoadMap roadMap = new RoadMap();
        roadMap.setOccupation(fileReader.readLine());
        roadMap.setTitle(fileReader.readLine());
        while ((str = fileReader.readLine()) != null ){
            if(str.isBlank()) continue;
            if(str.startsWith("-")) break;
            if(str.startsWith("**")) {
                if (str.contains("개월") || str.contains("월")) {
                    status = Status.Section;
                    section = str;
                }else if(str.contains("추천") || str.contains("권장")){
                    status = Status.Additional;
                }else{
                    status = Status.Tip;
                }
            } else if(str.contains("*")){
                switch (status){
                    case Section -> roadMap.addContentBySection(section, str);
                    case Additional -> roadMap.addAdditionalDataBySection(section, str);
                    case Tip -> roadMap.addTip(str);

                }
            }
        }
        return roadMap;
    }
}

enum Status{
    Section, Additional, Tip
}
