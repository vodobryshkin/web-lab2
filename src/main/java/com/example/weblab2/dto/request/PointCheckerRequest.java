package com.example.weblab2.dto.request;

import com.example.weblab2.web.ValManagerType;
import lombok.Data;

/**
 * DTO для передачи данных в PointCheckerService.
 */
@Data
public class PointCheckerRequest {
    private final String x;
    private final String y;
    private final String r;
    private final ValManagerType valManagerType;
}
