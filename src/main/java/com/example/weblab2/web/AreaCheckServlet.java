package com.example.weblab2.web;

import com.example.weblab2.dto.request.CheckerStage;
import com.example.weblab2.dto.request.PointCheckerRequest;
import com.example.weblab2.dto.response.PointCheckerResponse;
import com.example.weblab2.repository.appcontext.ApplicationContextRepository;
import com.example.weblab2.repository.interfaces.Repository;
import com.example.weblab2.service.PointCheckerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Сервлет, осуществляющий проверку попадания точки в область на координатной плоскости и формирующий HTML-страницу
 * с результатами проверки. Обрабатывает все запросы, содержащие сведения о координатах точки и радиусе области.
 */
@Slf4j
@Setter
@WebServlet(name = "AreaCheckServlet", urlPatterns = {"/points/check"})
public class AreaCheckServlet extends HttpServlet {
    private PointCheckerService pointCheckerService;
    private Repository repository;

    /**
     * Метод инициализации сервлета.
     * При инициализации создаётся сервис по проверке точек, происходит связь с бизнес-логикой.
     */
    @Override
    public void init() {
        String validationPath;
        try {
            validationPath = Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("validation.json")).toURI()
            ).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String areasPath;
        try {
            areasPath = Paths.get(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("areas.json")).toURI()
            ).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            pointCheckerService = new PointCheckerService(validationPath, areasPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        repository = new ApplicationContextRepository(getServletContext());
    }

    /**
     * Обработчик GET-запроса.
     * На этот сервлет приходят запросы, содержащие информацию о точке и типе проверки.
     * Сначала из query string формируется DTO для отправки на pointCheckerService, а затем от него приходит DTO
     * с результатом. Если проверка закончилась на этапе валдиации, то возвращаем код 422 (Unprocessable Entity).
     * Если валидация прошла успешно, и точка прошла полную проверку, то сохраняем результат попадания в репозиторий.
     *
     * @param req запрос
     * @param resp ответ
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Got request with queryString={} from the ControllerServlet", req.getQueryString());

        PointCheckerRequest pointCheckerRequest = new PointCheckerRequest(req.getQueryString());
        PointCheckerResponse pointCheckerResponse = pointCheckerService.check(pointCheckerRequest);

        if (pointCheckerResponse.getCheckerStage() == CheckerStage.Validation) {
            resp.setStatus(422);
            req.getRequestDispatcher("/WEB-INF/errors/422.jsp").forward(req, resp);
            return;
        }

        log.info("Get result of service logic: {}", pointCheckerResponse);

        req.getSession().setAttribute("result", pointCheckerResponse);

        repository.add(pointCheckerResponse);

        resp.sendRedirect(req.getContextPath() + "/result");
    }
}
