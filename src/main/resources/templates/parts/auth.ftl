<#macro login path>
<div class="login-form">
    <form method="post" action="${path}" class="login-form__content">
        <h4 class="login-form__title">Вход</h4>
        <#if RequestParameters.error??>
            <div>Invalid username and password</div>
        </#if>
        <#if RequestParameters.logout??>
            <div>You have been logged out</div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <label for="input-username" class="login-form__label-username">Логин</label>
        <input autofocus
               type="text"
               name="username"
               placeholder="Введите логин"
               id="input-username"
               class="login-form__input-username"/>
        <label for="input-password" class="login-form__label-password">Пароль</label>
        <input type="password"
               name="password"
               placeholder="Введите пароль"
               id="input-password"
               class="login-form__input-password"/>
        <input type="submit" value="Войти" class="login-form__button-submit"/>
        <a href="/registration" class="login-form__link-registration">Зарегистрируйтесь</a>
    </form>
</div>

    <script src="js/auth.js"></script>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" value="Sign Out"/>
</form>

</#macro>