"use strict";


var loginInput = document.querySelector('.login-form__input-username');
var passwordInput = document.querySelector('.login-form__input-password');

loginInput.onkeydown = function (e) {
    if (loginInput.value.length > 16 &&
        e.code !== 'Backspace' &&
        e.code !== 'Delete') {
        e.preventDefault();
    }
};

passwordInput.onkeydown = function (e) {
    if (passwordInput.value.length > 24 &&
        e.code !== 'Backspace' &&
        e.code !== 'Delete') {
        e.preventDefault();
    }
};