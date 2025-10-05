package com.example.weblab2.repository.appcontext;

import com.example.weblab2.dto.response.PointCheckerResponse;
import com.example.weblab2.repository.interfaces.Repository;
import jakarta.servlet.ServletContext;

import java.util.List;

/**
 * Репозиторий на основе хранилища контекста приложения.
 */
public class ApplicationContextRepository implements Repository {
    ServletContext servletContext;

    public ApplicationContextRepository(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @SuppressWarnings("unchecked")
    private List<PointCheckerResponse> getAll() {
        return (List<PointCheckerResponse>) servletContext.getAttribute("points");
    }

    /**
     * Добавление информации о проверке попадания в репозиторий.
     *
     * @param pointCheckerResponse результат проверки на попадание точки в область.
     */
    @Override
    public void add(PointCheckerResponse pointCheckerResponse) {
        getAll().add(pointCheckerResponse);
    }
}
