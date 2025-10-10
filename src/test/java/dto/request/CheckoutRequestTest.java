package dto.request;

import com.example.weblab2.dto.request.CheckoutRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.gmt.geometry.model.Point;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutRequestTest {
    @Test
    @DisplayName("Проверка на то, что два конструктора вернут одно значение")
    public void constructorsIsEqualTest() {
        String x = "5";
        String y = "5";
        String r = "5";

        BigDecimal xBd = new BigDecimal(x);
        BigDecimal yBd = new BigDecimal(y);
        BigDecimal rBd = new BigDecimal(r);

        Point point = new Point(xBd, yBd);

        assertEquals(new CheckoutRequest(x, y, r), new CheckoutRequest(point, rBd));
    }
}
