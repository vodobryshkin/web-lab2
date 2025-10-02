package com.example.weblab2.servlets;

import com.example.weblab2.checker.impl.QueryStringChecker;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/points")
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String queryString = req.getQueryString();

        if (queryString == null || !new QueryStringChecker().check(queryString)) {
            resp.sendRedirect("/");
            return;
        }

        resp.sendRedirect("/points/check?" + queryString);
    }
}
