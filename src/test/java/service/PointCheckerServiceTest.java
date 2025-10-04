package service;

import com.example.weblab2.dto.request.CheckerStage;
import com.example.weblab2.dto.request.PointCheckerRequest;
import com.example.weblab2.dto.response.PointCheckerResponse;
import com.example.weblab2.service.PointCheckerService;
import com.example.weblab2.web.ValManagerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointCheckerServiceTest {
    private final String valConf = "/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/validation.json";
    private final String areaConf = "/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json";

    @Test
    @DisplayName("Корректная точка с правильными данными попадает. X Y важны. r=1. Прямоугольник")
    public void testTrueDataRectangleXYMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "0.5";
        String y = "0.5";
        String r = "1";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, true, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с правильными данными попадает. X Y не важны. r=1. Прямоугольник")
    public void testTrueDataRectangleXGoodYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "0.5";
        String y = "0.7";
        String r = "1";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, true, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не попадает. X Y неважны. r=1. Прямоугольник")
    public void testTrueDataRectangleXYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-123123";
        String y = "313";
        String r = "1";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не проходит валидацию. X Y неважны. r=1. Прямоугольник")
    public void testFalseDataRectangleXYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-12312dd3";
        String y = "d313";
        String r = "1";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Validation);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не проходит валидацию. X Y важны. r=1. Прямоугольник")
    public void testFalseDataRectangleXYMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "0.7";
        String y = "0.7";
        String r = "1";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Validation);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с правильными данными попадает. X Y важны. r=2. Треугольник")
    public void testTrueDataTriangleXYMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-0.5";
        String y = "-0.5";
        String r = "2";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, true, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с правильными данными попадает. X Y не важны. r=2. Треугольник")
    public void testTrueDataTriangleXGoodYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-0.9";
        String y = "-0.4";
        String r = "2";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, true, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не попадает. X Y неважны. r=2. Треугольник")
    public void testTrueDataTriangleXYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-123123";
        String y = "313";
        String r = "2";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не проходит валидацию. X Y неважны. r=2. Треугольник")
    public void testFalseDataTriangleXYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-12312dd3";
        String y = "d313";
        String r = "2";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Validation);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не проходит валидацию. X Y важны. r=2. Треугольник")
    public void testFalseDataTriangleXYMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-0.9";
        String y = "-0.4";
        String r = "2";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Validation);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с правильными данными попадает. X Y важны. r=2.5. Круг")
    public void testTrueDataCircleXYMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "0.5";
        String y = "-0.5";
        String r = "2.5";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, true, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с правильными данными попадает. X Y не важны. r=2.5. Круг")
    public void testTrueDataCircleXGoodYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "0.5";
        String y = "-0.4";
        String r = "2.5";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, true, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не попадает. X Y неважны. r=2.5. Круг")
    public void testTrueDataCircleXYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-123123";
        String y = "313";
        String r = "2.5";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Checkout);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не проходит валидацию. X Y неважны. r=2.5. Круг")
    public void testFalseDataCircleXYNoMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "-12312dd3";
        String y = "d313";
        String r = "2.5";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Validation);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }

    @Test
    @DisplayName("Корректная точка с неправильными данными не проходит валидацию. X Y важны. r=2.5. Круг")
    public void testFalseDataCircleXYMatterR1() throws IOException {
        PointCheckerService pointCheckerService = new PointCheckerService(valConf, areaConf);

        String x = "0.5";
        String y = "-0.4";
        String r = "2.5";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        PointCheckerResponse pointCheckerResponse = new PointCheckerResponse(x, y, r, false, CheckerStage.Validation);

        assertEquals(pointCheckerResponse, pointCheckerService.check(pointCheckerRequest));
    }
}
