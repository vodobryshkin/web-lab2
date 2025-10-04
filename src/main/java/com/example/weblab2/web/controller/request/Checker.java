package com.example.weblab2.web.controller.request;

/**
 * Интерфейс для определения функциональности проверщиков запроса
 */
public interface Checker {
    /**
     * Функция на проверку корректности отправленных данных
     *
     * @param data информация на проверку
     * @return корректны ли проверяемые данные или нет
     */
    boolean check(String data);
}
