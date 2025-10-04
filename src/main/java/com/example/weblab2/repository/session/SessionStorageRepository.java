package com.example.weblab2.repository.session;

import com.example.weblab2.dto.response.PointCheckerResponse;
import com.example.weblab2.repository.interfaces.Repository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

import java.util.List;

/**
 * Репозиторий на основе хранилища JSP-сессии.
 */
public class SessionStorageRepository implements Repository {
    @Setter
    private HttpServletRequest httpServletRequest = null;

    /**
     * Добавление информации о проверке попадания в репозиторий.
     * Для репозитория на основе Session Storage так же необходимо перед тем, как использовать add установить request.
     *
     * @param pointCheckerResponse результат проверки на попадание точки в область.
     */
    @Override
    public void add(PointCheckerResponse pointCheckerResponse) {
        if (httpServletRequest != null) {
            @SuppressWarnings("unchecked")
            List<PointCheckerResponse> pointCheckerResponseList = (List<PointCheckerResponse>) httpServletRequest.getSession().getAttribute("points");
            pointCheckerResponseList.add(pointCheckerResponse);
            httpServletRequest.getSession().setAttribute("points", pointCheckerResponseList);
            setHttpServletRequest(null);
        }
    }
}
