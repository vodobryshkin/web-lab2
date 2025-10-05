<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
    <head>
        <title>Ошибка 400: запрос некорректен</title>
        <link rel="stylesheet" href="../../static/css/body.css">
        <link rel="stylesheet" href="../../static/css/header.css">
        <link rel="stylesheet" href="../../static/css/header__element.css">
    </head>
    <body>
    <header class="header">
        <h1 class="header__element header__element_nsf">Dobryshkin Vladimir Aleksandrovich</h1>
        <h1 class="header__element header__element_group-number">P3207</h1>
        <h1 class="header__element header__element_variant">Variant 853932</h1>
        <a href="https://en.wikipedia.org/wiki/The_Godfather" target="_blank" rel="noopener noreferrer">
            <img src="../../static/images/godfather-logo.png" alt="Logo of the Godfather">
        </a>
    </header>
        <h1>Упс! Что-то пошло не так.</h1>
        <p>Запрос: ${pageContext.request.requestURI}</p>
        <a class="start-page-link" href="${pageContext.request.contextPath}/">
            <button class="search-tag-link_btn">На стартовую страницу</button>
        </a>
    </body>
</html>
