package com.example.weblab2.web.listener;

import com.example.weblab2.dto.response.PointCheckerResponse;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс для реализации листенера http-сессии
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    /**
     * Метод необходим для создания списка, в котором будут лежать все результаты проверок, и для того, чтобы положить
     * его в Session Storage.
     *
     * @param se событие сессии
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        List<PointCheckerResponse> points = Collections.synchronizedList(new ArrayList<>());
        se.getSession().setAttribute("points", points);
    }
}
