package com.example.silkroad.service;

import com.example.silkroad.dto.RoadMapRequest;
import com.example.silkroad.dto.RoadMapResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class RoadMapService {
    //TODO : text를 읽어오는 것이 아닌 Server to Server 연결 구현 예정
//    BufferedReader fileReader = new BufferedReader( new FileReader("RoadMap_bard.txt"));
    String testRoadMap =
            "backend Developer\n" +
            "**1년간의 백엔드 개발자 로드맵 (월간 기준)**\n" +
            "\n" +
            "**1-3개월**\n" +
            "\n" +
            "* 프로그래밍 언어, 데이터베이스, 웹 서버 등 백엔드 개발의 기본 사항 학습\n" +
            "* Django나 Flask와 같은 인기 있는 프레임워크를 사용하여 간단한 백엔드 애플리케이션 구축\n" +
            "* 애플리케이션을 운영 환경에 배포하기\n" +
            "\n" +
            "**추천 자격증 및 자료:**\n" +
            "\n" +
            "* Google Cloud Certified Professional Cloud Developer\n" +
            "* AWS Certified Developer - Associate\n" +
            "* Microsoft Azure Developer Associate\n" +
            "\n" +
            "**4-6개월**\n" +
            "\n" +
            "* 백엔드 아키텍처와 디자인 패턴에 대해 학습\n" +
            "* 캐싱과 로드 밸런싱에 대해 학습\n" +
            "* 백엔드 개발을 위한 보안 최적의 방법 학습\n" +
            "\n" +
            "**추천 자격증 및 자료:**\n" +
            "\n" +
            "* \"Clean Architecture: A Craftsman's Guide to Software Structure and Design\" - Robert C. Martin\n" +
            "* \"Design Patterns: Elements of Reusable Object-Oriented Software\" - Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides\n" +
            "* \"Web Application Security\" - OWASP\n" +
            "\n" +
            "**7-9개월**\n" +
            "\n" +
            "* 분산 시스템과 마이크로서비스에 대해 학습\n" +
            "* 메시지 큐 및 비동기 통신에 대해 학습\n" +
            "* 테스트 및 지속적인 통합/지속적인 배포 (CI/CD)에 대해 학습\n" +
            "\n" +
            "**추천 자격증 및 자료:**\n" +
            "\n" +
            "* \"Building Microservices\" - Sam Newman\n" +
            "* \"Messaging Patterns\" - Gregor Hohpe\n" +
            "* \"Continuous Delivery: Reliable Software Releases Through Build, Test, and Deployment Automation\" - Jez Humble, David Farley\n" +
            "\n" +
            "**10-12개월**\n" +
            "\n" +
            "* 클라우드 컴퓨팅 플랫폼에 대해 학습하고 백엔드 애플리케이션을 클라우드에 배포하는 방법 학습\n" +
            "* 서버리스 컴퓨팅 및 컨테이너화 기술에 대해 학습\n" +
            "* 모니터링 및 관찰성 최적의 방법 학습\n" +
            "\n" +
            "**추천 자격증 및 자료:**\n" +
            "\n" +
            "* AWS Certified Solutions Architect - Associate\n" +
            "* Microsoft Azure Solutions Architect Expert\n" +
            "* Google Cloud Certified Professional Cloud Architect\n" +
            "\n" +
            "**추가 팁:**\n" +
            "\n" +
            "* 최신 백엔드 개발 동향과 기술을 학습하고 따르세요.\n" +
            "* 백엔드 개발 블로그와 기사를 읽으세요.\n" +
            "* 백엔드 개발 컨퍼런스와 이벤트에 참석하세요.\n" +
            "* 다른 백엔드 개발자들과 네트워킹하세요.\n" +
            "\n" +
            "이 로드맵은 단순히 제안일 뿐이며, 개인의 기술과 경험에 따라 조정해야 합니다. 또한, 이 로드맵은 백엔드 개발의 모든 측면을 다루지 않습니다. 계속해서 학습하고 성장하면서 새로운 백엔드 개발 영역을 발견하게 될 수 있으며, 해당 분야에 중점을 둘 수도 있습니다.";
    List<String> textList = new ArrayList<>();

    public RoadMapService() throws IOException {
    }

//    public RoadMapResponse getRoadMap() throws IOException {
//        String str, section = "";
//        Status status = null;
//
//        RoadMapResponse roadMapResponse = new RoadMapResponse();
//        roadMapResponse.setOccupation(fileReader.readLine());
//        roadMapResponse.setTitle(fileReader.readLine());
//        while ((str = fileReader.readLine()) != null ){
//            if(str.isBlank()) continue;
//            if(str.startsWith("-")) break;
//            if(str.startsWith("**")) {
//                if (str.contains("개월") || str.contains("월")) {
//                    status = Status.Section;
//                    section = str;
//                }else if(str.contains("추천") || str.contains("권장")){
//                    status = Status.Additional;
//                }else{
//                    status = Status.Tip;
//                }
//            } else if(str.contains("*")){
//                switch (status){
//                    case Section -> roadMapResponse.addContentBySection(section, str);
//                    case Additional -> roadMapResponse.addAdditionalDataBySection(section, str);
//                    case Tip -> roadMapResponse.addTip(str);
//
//                }
//            }
//        }
//        return roadMapResponse;
//    }

    public String GenerateRoadMapFromPython(RoadMapRequest request){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("api/occupation")
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        return response.getBody();
    }

    public RoadMapResponse convertStringToRoadMap(String roadMap){
        List<String> lines = new ArrayList<>();
        String section = "";
        Status status = null;
        lines = testRoadMap.lines()
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());
        RoadMapResponse roadMapResponse = new RoadMapResponse();
        roadMapResponse.setOccupation(lines.get(0));
        roadMapResponse.setTitle(lines.get(1));

        for(int i = 2; i < lines.size(); i++){
            String str = lines.get(i);
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
                    case Section -> roadMapResponse.addContentBySection(section, str);
                    case Additional -> roadMapResponse.addAdditionalDataBySection(section, str);
                    case Tip -> roadMapResponse.addTip(str);

                }
            }
        }
        return roadMapResponse;
    }
}

enum Status{
    Section, Additional, Tip
}
