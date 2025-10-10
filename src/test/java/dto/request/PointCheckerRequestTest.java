package dto.request;

import com.example.weblab2.dto.request.PointCheckerRequest;
import com.example.weblab2.web.ValManagerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointCheckerRequestTest {
    @Test
    @DisplayName("Проверка на то, что два конструктора дают эквивалентный результат. Type = full")
    public void twoConstructorsEqualFull() {
        String x = "5";
        String y = "5";
        String r = "5";
        ValManagerType valManagerType = ValManagerType.Full;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        assertEquals(new PointCheckerRequest("?x=5&y=5&r=5&type=\"full\""), pointCheckerRequest);
    }

    @Test
    @DisplayName("Проверка на то, что два конструктора дают эквивалентный результат. Type = only_r")
    public void twoConstructorsEqualR() {
        String x = "5";
        String y = "5";
        String r = "5";
        ValManagerType valManagerType = ValManagerType.OnlyR;

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(x, y, r, valManagerType);
        assertEquals(new PointCheckerRequest("?x=5&y=5&r=5&type=\"only_r\""), pointCheckerRequest);
    }
}
