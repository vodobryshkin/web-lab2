<jsp:useBean id="result" scope="request" type="com.example.weblab2.dto.response.PointCheckerResponse"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Результат</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/body.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header__element.css">
    </head>
    <body>
        <header class="header">
            <h1 class="header__element header__element_nsf">Dobryshkin Vladimir Aleksandrovich</h1>
            <h1 class="header__element header__element_group-number">P3207</h1>
            <h1 class="header__element header__element_variant">Variant 853932</h1>
            <a href="https://en.wikipedia.org/wiki/The_Godfather" target="_blank" rel="noopener noreferrer">
                <img src="${pageContext.request.contextPath}/static/images/godfather-logo.png" alt="Logo of the Godfather">
            </a>
        </header>
        <section class="result-section">
            <div class="table__wrapper">
                <table id="result-table">
                    <tr>
                        <th>X</th>
                        <th>Y</th>
                        <th>R</th>
                        <th>Попадание</th>
                    </tr>
                    <tr>
                        <td>${result.x}</td>
                        <td>${result.y}</td>
                        <td>${result.r}</td>
                        <td>${result.status? "Попал" : "Не попал"}</td>
                    </tr>
                </table>
            </div>
            <a class="start-page-link" href="${pageContext.request.contextPath}/">
                <button class="search-tag-link_btn">На стартовую страницу</button>
            </a>
        </section>
        <canvas id="canvas" width="600" height="600" data-x="${result.x}" data-y="${result.y}" data-r="${result.r}"></canvas>
        <script type="module">
            import {drawPoint, draw} from "../static/js/scripts/canvas.js";
            const canvas = document.getElementById('canvas');
            const { x, y, r } = canvas.dataset;
            draw(r);
            drawPoint(x, y, r);
        </script>
    </body>
</html>
