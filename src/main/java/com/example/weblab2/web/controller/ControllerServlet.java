package com.example.weblab2.web.controller;

import com.example.weblab2.web.controller.request.QueryStringChecker;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Сервлет, определяющий тип запроса, и, в зависимости от того, содержит ли запрос информацию о координатах точки и
 * радиусе, делегирующий его обработку одному из перечисленных ниже компонентов. Все запросы внутри приложения
 * передаются этому сервлету по методу GET.
 */
@Slf4j
@WebServlet(value = "/points")
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String queryString = req.getQueryString();

        log.info("The ControllerServlet received a request from the URL with queryString={}", req.getQueryString());

        if (queryString == null || !new QueryStringChecker().check(queryString)) {
            resp.sendRedirect(req.getContextPath() + "/");
            log.info("Query string is null or does not match pattern.");
            return;
        }

        log.info("Query string {} match the patter.", req.getQueryString());
        log.info("Redirected request to the AreaCheckServlet.");

        RequestDispatcher requestDispatcher = getServletContext().getNamedDispatcher("AreaCheckServlet");
        requestDispatcher.forward(req, resp);
    }
}

