package com.example.silkroad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoadMapRequest {
    String occupation;
    int period = 1;
    Period periodType = Period.YEAR;

}

enum Period{
    YEAR, MONTH
}
