<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
    <head>
        <title>Ошибка 400: запрос некорректен</title>
    </head>
    <body>
        <h1>Упс! Что-то пошло не так.</h1>
        <p>Запрос: ${pageContext.request.requestURI}</p>
        <a class="start-page-link" href="${pageContext.request.contextPath}/">
            <button class="search-tag-link_btn">На стартовую страницу</button>
        </a>
    </body>
</html>
