package com.example.weblab2.web.listener;

import com.example.weblab2.dto.response.PointCheckerResponse;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс для реализации листенера приложения
 */
@WebListener
public class AppResultsInitListener implements ServletContextListener {
    /**
     * Метод необходим для создания списка, в котором будут лежать все результаты проверок, и для того, чтобы положить
     * его в Application Context.
     *
     * @param sce событие сессии
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<PointCheckerResponse> shared =
                Collections.synchronizedList(new ArrayList<>());
        sce.getServletContext().setAttribute("points", shared);
    }

    /**
     * Метод необходим для удаления списка, в котором лежат все результаты проверок перед завершением работы.
     *
     * @param sce событие сессии
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("points");
    }
}
