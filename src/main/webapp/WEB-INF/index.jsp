<%@ page import="com.example.weblab2.dto.response.PointCheckerResponse" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Лабораторная работа по веб-программированию #2</title>
        <meta charset="UTF-8">
        <style>
            @font-face {
                font-family: 'Corleone-Regular';
                src: url('../static/css/assets/fonts/Corleone-Regular.woff2') format('woff2');
                font-display: swap;
            }

            @font-face {
                font-family: 'Corleone-Due-Regular';
                src: url('../static/css/assets/fonts/Corleone-Due-Regular.woff2') format('woff2');
                font-display: swap;
            }
            canvas {
                border: 1px solid;
            }
        </style>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Anton&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../static/css/body.css">
        <link rel="stylesheet" href="../static/css/header.css">
        <link rel="stylesheet" href="../static/css/header__element.css">
    </head>
        <header class="header">
            <h1 class="header__element header__element_nsf">Dobryshkin Vladimir Aleksandrovich</h1>
            <h1 class="header__element header__element_group-number">P3207</h1>
            <h1 class="header__element header__element_variant">Variant 853932</h1>
            <a href="https://en.wikipedia.org/wiki/The_Godfather">
                <img src="../static/images/godfather-logo.png" alt="Logo of the Godfather">
            </a>
        </header>

        <section class="task-section">
            <form class="task-section__form task-form" id="task-form" method="get" action="${pageContext.request.contextPath}/points">
                <ul class="task-from__input-list input-list">
                    <li class="input-list__element input-list__element-x">
                        <label class="task-form__label task-form__label_x" for="input-x">
                            X Value:
                            <input class="task-form__input-x" id="input-x" name="x"
                                   placeholder="Введите число от -5 до 3" type="text">
                        </label>
                    </li>

                    <li class="input-list__element input-list__element-y">
                        <label class="task-form__label task-form__label_y" for="select-y">
                            Y Value:
                            <select class="select__element-y" id="select-y" name="y" required>
                                <option value="" disabled selected hidden>...</option>
                                <option value="-2">-2</option>
                                <option value="-1.5">-1.5</option>
                                <option value="-1">-1</option>
                                <option value="-0.5">-0.5</option>
                                <option value="0">0</option>
                                <option value="0.5">0.5</option>
                                <option value="1">1</option>
                                <option value="1.5">1.5</option>
                                <option value="2">2</option>
                            </select>
                        </label>
                    </li>

                    <li class="input-list__element input-list__element-r">
                        <label class="task-form__label task-form__label_r" for="select-r">
                            R Value:
                            <select class="select__element-r" id="select-r" name="r" required>
                                <option value="" disabled selected hidden>...</option>
                                <option value="1">1</option>
                                <option value="1.5">1.5</option>
                                <option value="2">2</option>
                                <option value="2.5">2.5</option>
                                <option value="3">3</option>
                            </select>
                        </label>
                    </li>
                </ul>
                <input type="hidden" name="type" value="&quot;full&quot;">
                <button class="task-form__confirm-button" id="confirm-btn" type="submit">
                    Send point
                </button>
            </form>
            <canvas class="canvas" id="canvas" width="600" height="600"></canvas>
            <div class="table__wrapper">

                <table id="result-table">
                    <tr>
                        <th>X</th><th>Y</th><th>R</th><th>Попадание</th>
                    </tr>
                    <%
                        @SuppressWarnings("unchecked")
                        List<PointCheckerResponse> points =
                                (List<PointCheckerResponse>) application.getAttribute("points");

                        if (points != null && !points.isEmpty()) {
                            for (com.example.weblab2.dto.response.PointCheckerResponse point : points) {
                    %>
                        <tr>
                            <td><%= point.getX() %></td>
                            <td><%= point.getY() %></td>
                            <td><%= point.getR() %></td>
                            <td><%= point.isStatus() ? "Попал" : "Не попал" %></td>
                        </tr>
                    <%
                        }
                    }
                    %>
                </table>
            </div>
        </section>

        <footer class="footer">

        </footer>


        <script src="../static/js/scripts/submition.js" type="module"></script>
        <script src="../static/js/scripts/main.js" type="module"></script>

        <script type="module">
        import {drawPoint, draw} from "../static/js/scripts/canvas.js";
        import {validateR} from "../static/js/scripts/validation.js";

        window.drawPoint = drawPoint;

        const rChoiceInput = document.getElementById("select-r");

        rChoiceInput.addEventListener('change', () => {redrawCanvas(rChoiceInput.value)});

        function redrawCanvas(r) {
            if (typeof validateR(r) !== "string") {
                draw(Number(r));
                <% if (points != null) {
                        for (PointCheckerResponse p : points) { %>
                            window.drawPoint(<%= p.getX() %>, <%= p.getY() %>, r);
                <%      }
                   }
                %>
            }
        }
        </script>
</html>