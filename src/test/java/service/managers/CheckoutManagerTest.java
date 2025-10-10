package service.managers;

import com.example.weblab2.dto.request.CheckoutRequest;
import com.example.weblab2.service.managers.CheckoutManager;
import ru.ifmo.se.gmt.geometry.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutManagerTest {
    @Test
    @DisplayName("Точка попала1")
    void pointIsInTheAreasTest1() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("1"), new BigDecimal("1")),
                new BigDecimal("5"));

        assertTrue(checkoutManager.checkRequest(checkoutRequest));
    }

    @Test
    @DisplayName("Точка попала2")
    void pointIsInTheAreasTest2() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("0.5"), new BigDecimal("-0.5")),
                new BigDecimal("3"));

        assertTrue(checkoutManager.checkRequest(checkoutRequest));
    }

    @Test
    @DisplayName("Точка попала3")
    void pointIsInTheAreasTest3() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("0"), new BigDecimal("0")),
                new BigDecimal("5"));

        assertTrue(checkoutManager.checkRequest(checkoutRequest));
    }

    @Test
    @DisplayName("Точка не попала1")
    void pointIsNotInTheAreasTest1() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("10"), new BigDecimal("1")),
                new BigDecimal("5"));

        assertFalse(checkoutManager.checkRequest(checkoutRequest));
    }

    @Test
    @DisplayName("Точка не попала2")
    void pointIsNotInTheAreasTest2() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("4"), new BigDecimal("-4")),
                new BigDecimal("4"));

        assertFalse(checkoutManager.checkRequest(checkoutRequest));
    }

    @Test
    @DisplayName("Точка не попала3")
    void pointIsNotInTheAreasTest3() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("-2"), new BigDecimal("-2")),
                new BigDecimal("4"));

        assertFalse(checkoutManager.checkRequest(checkoutRequest));
    }

    @Test
    @DisplayName("Точка не попала4")
    void pointIsNotInTheAreasTest4() throws IOException {
        CheckoutManager checkoutManager = new CheckoutManager("/home/vodobryshkin/progs/proj/IdeaProjects/web-lab2/src/main/resources/areas.json");
        CheckoutRequest checkoutRequest = new CheckoutRequest(new Point(new BigDecimal("1.5"), new BigDecimal("-1.5")),
                new BigDecimal("3"));

        assertFalse(checkoutManager.checkRequest(checkoutRequest));
    }
}
