<#import "parts/common.ftl" as c>

<@c.page>

<div id="action_form" class="registration-form" >
    <form method="post" action="/registration" class="registration-form__content">
        <h4 class="registration-form__title">Регистрация</h4>

        <label for="registration-username"
               class="registration-form__label-username"
        >
            Введите логин
        </label>
        <p class="registration-form__advice-username">(Введите от 4 до 20 символов)*</p>
        <input id="registration-username"
               name="username"
               autofocus
               type="text"
               placeholder="Введите логин"
               class="registration-form__input-username">

        <label for="registration-password"
               class="registration-form__label-password"
        >
            Введите пароль
        </label>
        <p class="registration-form__advice-password">(Введите от 6 до 25 символов)*</p>
        <input id="registration-password"
               name="password"
               type="password"
               placeholder="Введите пароль"
               class="registration-form__input-password">

        <label for="registration-repeat-password"
               class="registration-form__label-repeat-password"
        >
            Повторите пароль
        </label>
        <p class="registration-form__advice-repeat-password">(Пароль должен совпадать)*</p>
        <input id="registration-repeat-password"
               type="password"
               placeholder="Повторите пароль"
               class="registration-form__input-repeat-password">

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit"
                class="registration-form__button-submit"
        >
            Зарегистрироваться
        </button>

        <a href="/login" class="registration-form__login-link">Или ввойдите, если есть аккаунт</a>
    </form>

    <script src="js/registration.js"></script>

    <#if isLoginExists?ifExists>
        <div class="registration-form__notification-area">
            <p class="registration-form__notification-message">${loginExistsNotification?ifExists}</p>
            <button class="registration-form__notification-submit">ОК</button>
        </div>
        <script src="js/registration-popup.js"></script>
    </#if>

</div>



</@c.page>

