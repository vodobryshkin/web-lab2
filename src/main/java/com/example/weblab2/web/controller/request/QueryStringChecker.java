package com.example.weblab2.web.controller.request;

public class QueryStringChecker implements Checker {
    /**
     * Функция на проверку корректности query string в GET запросе
     *
     * @param queryString информация на проверку
     * @return корректны ли проверяемые данные или нет
     */
    @Override
    public boolean check(String queryString) {
        String regexPattern = "x=.+&y=.+&r=.+&type=%22(?:full|only_r)%22";

        return queryString.matches(regexPattern);
    }
}
