<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>TaskBar</title>
    <link rel='stylesheet' href='css/auth.css'>
    <link rel='stylesheet' href='css/common.css'>
</head>
<body>
    <header class="header">
        <a href="/" class="header__link-logo-image">
            <img src="image/logo.png" alt="Логотип" class="header__logo-image">
        </a>
        <a href="/" class="header__title">TaskBar</a>
        <a href="/" class="header__link-user-image">
            <img src="image/anonymous-user.png" alt="Аватар пользователя" class="header__user-image">
        </a>
    </header>

    <#nested>

    <script src="js/auth.js"></script>
</body>
</html>
</#macro>