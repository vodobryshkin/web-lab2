package com.example.weblab2.service;

import com.example.weblab2.dto.request.CheckerStage;
import com.example.weblab2.dto.request.CheckoutRequest;
import com.example.weblab2.dto.request.PointCheckerRequest;
import com.example.weblab2.dto.response.PointCheckerResponse;
import com.example.weblab2.service.managers.CheckoutManager;
import com.example.weblab2.web.ValManagerType;

import lombok.Setter;
import ru.ifmo.se.validation.managers.ValidationCompleteManager;
import ru.ifmo.se.validation.managers.ValidationRManager;
import ru.ifmo.se.validation.managers.interfaces.ValidationManager;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.io.IOException;

/**
 * Класс, реализующий сервис по проверке попадания точки в выбранную область.
 */
public class PointCheckerService {
    @Setter
    private ValidationManager validationManager;
    private final String valConfigPath;
    private final CheckoutManager checkoutManager;

    public PointCheckerService(String valConfigPath, String areaConfigPath) throws IOException {
        validationManager = new ValidationCompleteManager(valConfigPath);
        checkoutManager = new CheckoutManager(areaConfigPath);

        this.valConfigPath = valConfigPath;
    }

    /**
     * Функция для проверки бизнес-логикой.
     * 1. Сначала происходит проверка на то, какой ValidationManager использовать. Если пришел запрос на полную проверку,
     * а текущий manager проверяет только R, то нужно его поменять и наоборот.
     * 2. После этого формируется запрос на валидацию и сама валидация. Результат валидации хранится в переменной status.
     * Если валидация прошла неудачно, то
     * 3.
     *
     * @param request запрос на проверку бизнес логики.
     */
    public PointCheckerResponse check(PointCheckerRequest request) throws IOException {
        if (request.getValManagerType() == ValManagerType.Full && validationManager instanceof ValidationRManager
                || request.getValManagerType() == ValManagerType.OnlyR && validationManager instanceof ValidationCompleteManager) {
            resetValidationManager();
        }

        ValidationRequest validationRequest = new ValidationRequest(request.getX(), request.getY(), request.getR());

        if (!validationManager.validate(validationRequest)) {
            return new PointCheckerResponse(false, CheckerStage.Validation);
        }

        CheckoutRequest checkoutRequest = new CheckoutRequest(request.getX(), request.getY(), request.getR());

        return new PointCheckerResponse(checkoutManager.checkRequest(checkoutRequest), CheckerStage.Checkout);
    }

    // Переключение менеджера валидации
    private void resetValidationManager() throws IOException {
        if (validationManager instanceof ValidationCompleteManager) {
            setValidationManager(new ValidationRManager(valConfigPath));
            return;
        }
        setValidationManager(new ValidationCompleteManager(valConfigPath));
    }
}
