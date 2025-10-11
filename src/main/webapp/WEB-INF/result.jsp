<jsp:useBean id="result" scope="session" type="com.example.weblab2.dto.response.PointCheckerResponse"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Result</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Anton&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/body.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/header__element.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/task-section.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form-wrapper.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/canvas.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/table.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/footer.css">
        <style>
            .result-section {
                display: flex;
                flex-direction: column;
                align-items: center;
                gap: 24px;
                max-width: 1100px;
                margin: 28px auto 64px;
                padding: 0 20px;
            }

            .result-section > div {
                background:
                        radial-gradient(140% 100% at 100% 0%, rgba(184,144,46,.06), transparent 60%),
                        #1F1713;
                border:1px solid #2B2320;
                border-radius:16px;
                padding:20px;
                box-shadow:0 12px 30px rgba(0,0,0,.45);
            }
        </style>
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
                        <th>Status</th>
                    </tr>
                    <tr>
                        <td>${result.x}</td>
                        <td>${result.y}</td>
                        <td>${result.r}</td>
                        <td>${result.status? "Hit" : "Missed"}</td>
                    </tr>
                </table>
            </div>
            <canvas id="canvas" width="600" height="600" data-x="${result.x}" data-y="${result.y}" data-r="${result.r}"></canvas>
            <a class="start-page-link" href="${pageContext.request.contextPath}/">
                <button class="search-tag-link_btn" id="confirm-btn">To the start page</button>
            </a>
        </section>
        <footer class="footer">
            <h3>Made by vododbryshkin</h3>
            <h5><a href="https://github.com/vodobryshkin/web-lab2" target="_blank" rel="noopener noreferrer"><img alt="значок гитхаба" src="${pageContext.request.contextPath}/static/images/github.png"></a></h5>
            <h5><a href="https://youtu.be/N1TClA5CVkQ?si=uOOxoMXAQSyoZoNH" target="_blank" rel="noopener noreferrer"><img alt="вито корлеоне" src="${pageContext.request.contextPath}/static/images/vito-norm.png"></a></h5>
        </footer>
        <script type="module">
            import {drawPoint, draw} from "${pageContext.request.contextPath}/static/js/scripts/canvas.js";
            const canvas = document.getElementById('canvas');
            const { x, y, r } = canvas.dataset;
            draw(r);
            drawPoint(x, y, r);
        </script>
    </body>
</html>
