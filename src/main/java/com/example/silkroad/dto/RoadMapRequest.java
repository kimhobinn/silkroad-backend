package com.example.silkroad.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoadMapRequest {
    @NotBlank(message = "직업을 입력해주세요")
    @Size(max = 15, message = "직업 명이 너무 길어요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z]+$", message = "직업명을 정확히 입력해주세요")
    String occupation;
    int period = 1;
    Period periodType = Period.YEAR;

    @AssertTrue(message = "입력된 기간이 너무 짧습니다. 최소 6개월 이상의 로드맵을 그려보세요")
    public boolean isRequestMinimumPeriodCheck(){
        if(periodType == Period.MONTH && period < 6){
            return false;
        }
        return true;
    }
}

enum Period{
    YEAR, MONTH
}
