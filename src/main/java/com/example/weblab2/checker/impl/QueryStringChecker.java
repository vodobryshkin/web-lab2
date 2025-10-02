package com.example.weblab2.checker.impl;

import com.example.weblab2.checker.interfaces.Checker;

public class QueryStringChecker implements Checker {
    /**
     * Функция на проверку корректности query string в GET запросе
     *
     * @param queryString информация на проверку
     * @return корректны ли проверяемые данные или нет
     */
    @Override
    public boolean check(String queryString) {
        String regexPattern = "x=.+&y=.+&r=.+";

        return queryString.matches(regexPattern);
    }
}
