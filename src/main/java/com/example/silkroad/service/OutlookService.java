package com.example.silkroad.service;

import com.example.silkroad.dto.OutlookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OutlookService {
    //TODO : Server to Server 구현 예정
    String text =
            "**백엔드 개발자**\n" +
            "\n" +
            "**백엔드 개발자의 미래 전망**\n" +
            "\n" +
            "**긍정적인 요소:**\n" +
            "\n" +
            "* **성장하는 수요:** 비즈니스가 디지털 변환에 투자하는 동안 백엔드 개발자에 대한 수요가 앞으로 몇 년 동안 크게 증가할 것으로 예상됩니다. 웹 응용 프로그램, 모바일 앱 및 클라우드 기반 서비스의 사용이 증가함에 따라 이러한 변화가 주도되고 있습니다.\n" +
            "* **높은 연봉:** 백엔드 개발자는 최고 수준의 소프트웨어 개발자 중 하나입니다. 미국에서 백엔드 개발자의 중간 연봉은 100,000달러를 웃돕니다.\n" +
            "* **직업 안정성:** 백엔드 개발자는 많은 수요가 있으므로 좋은 직업 안정성을 가지고 있습니다. 경기 침체 기간에도 기존 시스템을 유지 및 업데이트하기 위해 백엔드 개발자에 대한 필요성이 여전히 있습니다.\n" +
            "* **승진 기회:** 백엔드 개발자는 자신의 경력을 발전시키기 위한 많은 기회가 있습니다. 관리 역할로 전환하거나 클라우드 컴퓨팅, 데이터 과학, 머신 러닝과 같은 특정 분야의 백엔드 개발에 전문화 할 수 있습니다.\n" +
            "\n" +
            "**부정적인 요소:**\n" +
            "\n" +
            "* **경쟁:** 백엔드 개발자 채용 경쟁은 특히 입문 수준의 직책에는 치열 할 수 있습니다. 경쟁에서 눈에 띄기 위해서는 강력한 포트폴리오를 갖고 최신 기술에 능란해야 합니다.\n" +
            "* **계속적인 학습 필요:** 백엔드 개발 분야는 지속적으로 진화하고 있기 때문에 개발자는 최신 동향과 기술에 대해 계속해서 최신 정보를 유지해야 합니다. 이는 상당한 시간과 노력 투자를 요구할 수 있습니다.\n" +
            "* **스트레스 있는 작업 환경:** 백엔드 개발자는 종종 타이트한 마감일 하에 복잡한 문제를 다루어야 합니다. 특히 새로운 개발자에게는 스트레스를 유발할 수 있는 작업 환경입니다.\n" +
            "\n" +
            "**추가적인 고려 사항:**\n" +
            "\n" +
            "* **인공지능(AI)과 기계 학습(ML)의 부상:** AI와 ML은 소프트웨어 개발에서 많은 작업을 자동화하기 위해 점점 더 많이 사용되고 있습니다. 이로 인해 어떤 분야에서는 백엔드 개발자의 수요가 줄어들 수도 있습니다. 하지만 AI와 ML은 또한 AI 기반 응용 프로그램 및 ML 기반 알고리즘 개발과 같은 새로운 백엔드 개발 기회를 창출하고 있습니다.\n" +
            "* **클라우드 컴퓨팅으로의 전환:** 클라우드 컴퓨팅으로의 전환은 백엔드 개발 분야에 영향을 미치는 또 다른 주요 트렌드입니다. 클라우드 컴퓨팅은 개발자가 응용 프로그램을 더 쉽고 효율적으로 배포 및 확장할 수 있게 해줍니다. 그러나 이는 개발자가 새로운 기술과 지식을 가져야 하는 요구 사항이기도 합니다.\n" +
            "\n" +
            "**결론:**\n" +
            "\n" +
            "백엔드 개발의 미래는 밝습니다. 그러나 개발자는 앞으로 나아가기 위해 도전과 기회에 대해 인식해야 합니다. 최신 동향과 기술에 대해 최신 정보를 유지하고 클라우드 기반 환경에서 작업할 수 있는 기술을 개발함으로써 백엔드 개발자는 앞으로의 성공을 위한 위치를 잡을 수 있습니다.\n" +
            "\n" +
            "**전문가의 관점:**\n" +
            "\n" +
            "위의 내용 외에도, 전문가 관점에서 백엔드 개발자의 미래 전망에 대해 몇 가지 추가적인 생각을 제시합니다:\n" +
            "\n" +
            "* **백엔드 개발자에 대한 수요는 앞으로의 몇 년 동안 평균 이상으로 빠르게 증가할 것으로 예상됩니다.** 이는 웹 기반 응용 프로그램, 모바일 앱 및 클라우드 기반 서비스에 대한 의존성의 증가 때문입니다.\n" +
            "* **AI와 ML 기술에 능숙한 백엔드 개발자는 수요가 높을 것입니다.** AI와 ML은 소프트웨어 개발에서 많은 작업을 자동화하는 데 사용되지만 백엔드 개발자에게는 새로운 기회를 창출하여 새롭고 혁신적인 응용 프로그램을 개발할 수 있습니다.\n" +
            "* **클라우드 컴퓨팅에 익숙한 백엔드 개발자 또한 수요가 많을 것입니다.** 클라우드 컴퓨팅은 응용 프로그램을 배포하고 확장하는 표준이 되고 있습니다.\n" +
            "* **문제 해결 및 분석 능력이 강한 백엔드 개발자는 항상 수요가 있을 것입니다.** 비즈니스 요구 사항을 이해하고 복잡한 문제를 해결하는 능력은 백엔드 개발자에게 필수적입니다.\n" +
            "\n" +
            "총론적으로, 백엔드 개발자의 미래 전망은 매우 좋습니다. 백엔드 개발자에 대한 수요는 앞으로 몇 년 동안 크게 증가할 것으로 예상되며, 적합한 기술과 경험을 갖춘 백엔드 개발자는 수요가 높을 것입니다.\n" +
            "\n" +
            "**백엔드 개발자를 위한 조언:**\n" +
            "\n" +
            "백엔드 개발자이시라면, 앞으로의 성공을 위해 앞서 나갈 수 있는 몇 가지 팁을 제시합니다:\n" +
            "\n" +
            "* **최신 동향과 기술에 대해 최신 정보를 유지하십시오.** 이는 AI, ML, 클라우드 컴퓨팅 및 기타 새로운 기술들을 포함합니다.\n" +
            "* **문제 해결 및 분석 능력을 개발하십시오.** 이러한 기술은 백엔드 개발자에게 필수적이며 앞으로 더욱 중요해질 것입니다.\n" +
            "* **강력한 포트폴리오를 구축하십시오.** 이는 취업시 경쟁에서 눈에 띄는데 도움이 됩니다.\n" +
            "* **다른 백엔드 개발자들과 네트워크를 형성하십시오.** 이는 새로운 기술과 기회에 대해 배우는 좋은 방법입니다.\n" +
            "\n" +
            "이러한 팁을 따르면 앞으로의 몇 년 동안 백엔드 개발자로서 성공할 수 있는 위치에 자리 잡을 수 있습니다.";

    public String GenerateOutlookFromPython(String request){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/outlook")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        return response.getBody();
    }

    public OutlookResponse convertStringToOutlook(String outlook){
        Status status = null;
        List<String> lines = new ArrayList<>();
        lines = text.lines()
                .filter(s -> !s.isBlank())
                .toList();
        OutlookResponse outlookResponse = new OutlookResponse();
        outlookResponse.setOccupation(lines.get(0));
        outlookResponse.setTitle(lines.get(1));
        for(int i = 2; i < lines.size(); i++){
            String str = lines.get(i);
            if(str.startsWith("**")){
                str = str.replace("*", "");
                str = str.strip();
                if(str.contains("긍정"))
                    status = Status.POSITIVE;
                else if(str.contains("부정"))
                    status = Status.NEGATIVE;
                else if(str.contains("조언") | str.contains("팁") || str.contains("고려"))
                    status = Status.CONSIDER;
                else if(str.contains("전문")) {
                    status = Status.EXPORT;
                }
            }
            else if(str.startsWith("*")){
                int idx = str.lastIndexOf("**");
                String key = str.substring(0, idx).replace("*", "").strip();
                String value = str.substring(idx).replace("*", "").strip();
                switch (status){
                    case POSITIVE -> outlookResponse.getPositive().put(key, value);
                    case NEGATIVE -> outlookResponse.getNegative().put(key, value);
                    case CONSIDER -> outlookResponse.getAdditionalConsider().put(key, value);
                    case EXPORT -> outlookResponse.getViewOfExpert().put(key, value);
                }

            }
            else{
                outlookResponse.getResult().add(str.replace("*", "").strip());
            }
        }
        return outlookResponse;
    }

    enum Status{
        POSITIVE, NEGATIVE, CONSIDER, EXPORT
    }
}
