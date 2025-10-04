package com.example.weblab2.dto.response;

import com.example.weblab2.dto.request.CheckerStage;
import lombok.Data;

/**
 * DTO для получения данных из CheckoutManager.
 */
@Data
public class PointCheckerResponse {
    private final boolean status;
    private final CheckerStage checkerStage;
}
