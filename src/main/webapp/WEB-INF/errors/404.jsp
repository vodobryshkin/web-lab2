<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <title>Code 404</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Anton&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../static/css/body.css">
    <link rel="stylesheet" href="../../static/css/header.css">
    <link rel="stylesheet" href="../../static/css/header__element.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/footer.css">
    <style>
        body {
            margin: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        button {
            padding-bottom: 6px;
            height: 30px;
            width: 250px;

            font-size: 16px;
            font-family: Anton, sans-serif;

            background-color: #E7DCC7;
            border-radius: 12px;
        }

        section {
            flex: 1 0 auto;
        }

        footer.footer {
            margin-top: auto;
        }
    </style>
</head>
<body>
<section>
    <header class="header">
        <h1 class="header__element header__element_nsf">Dobryshkin Vladimir Aleksandrovich</h1>
        <h1 class="header__element header__element_group-number">P3207</h1>
        <h1 class="header__element header__element_variant">Variant 853932</h1>
        <a href="https://en.wikipedia.org/wiki/The_Godfather" target="_blank" rel="noopener noreferrer">
            <img src="../../static/images/godfather-logo.png" alt="Logo of the Godfather">
        </a>
    </header>
    <h1>404 Not Found — the server can’t find a resource matching the request URL. The endpoint or file doesn’t exist
        (or isn’t exposed to the client).</h1>
    <p>Request: ${pageContext.request.requestURI}/${pageContext.request.queryString}</p>
    <a class="start-page-link" href="${pageContext.request.contextPath}/">
        <button class="search-tag-link_btn">To the start page</button>
    </a>
</section>
<footer class="footer">
    <h3>Made by vododbryshkin</h3>
    <h5><a href="https://github.com/vodobryshkin/web-lab2" target="_blank" rel="noopener noreferrer"><img alt="значок гитхаба" src="${pageContext.request.contextPath}/static/images/github.png"></a></h5>
    <h5><a href="https://youtu.be/N1TClA5CVkQ?si=uOOxoMXAQSyoZoNH" target="_blank" rel="noopener noreferrer"><img alt="вито корлеоне" src="${pageContext.request.contextPath}/static/images/vito-norm.png"></a></h5>
</footer>
</body>
</html>
