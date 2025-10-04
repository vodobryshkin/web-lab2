package com.example.weblab2.repository.interfaces;

import com.example.weblab2.dto.response.PointCheckerResponse;

/**
 * Класс для реализации репозитория для хранения информации о проверках.
 */
public interface Repository {
    /**
     * Добавление информации о проверке попадания в репозиторий.
     *
     * @param pointCheckerResponse результат проверки на попадание точки в область.
     */
    void add(PointCheckerResponse pointCheckerResponse);
}
