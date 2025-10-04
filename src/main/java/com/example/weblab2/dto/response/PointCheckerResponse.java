package com.example.weblab2.dto.response;

import com.example.weblab2.dto.request.CheckerStage;
import lombok.Data;

/**
 * DTO для получения данных из CheckoutManager.
 */
@Data
public class PointCheckerResponse {
    private final String x;
    private final String y;
    private final String r;
    private final boolean status;
    private final CheckerStage checkerStage;
}
