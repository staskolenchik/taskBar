"use strict";

var registrationFormElement = document.querySelector(".registration-form__content");

var adviceUsername = document.querySelector(".registration-form__advice-username");
var inputUsernameElement = document.querySelector(".registration-form__input-username");

var advicePassword = document.querySelector(".registration-form__advice-password");
var inputPasswordElement = document.querySelector(".registration-form__input-password");

var adviceRepeatPassword = document.querySelector(".registration-form__advice-repeat-password");
var inputRepeatPasswordElement = document.querySelector(".registration-form__input-repeat-password");

var isUsernameValid = false;
var isPasswordValid = false;
var isRepeatPasswordValid = false;

function validateUsername() {
    if (inputUsernameElement.value.length < 4) {
        outputInvalidUsernameMessage();
        isUsernameValid = false;
    } else {
        outputValidUsernameMessage();
        isUsernameValid = true;
    }
}

function limitUsernameLength(event) {
    if (inputUsernameElement.value.length > 19 &&
        event.code !== 'Backspace' &&
        event.code !== 'Delete') {
        event.preventDefault();
    }
}

function outputInvalidUsernameMessage() {
    console.log("Вы ввели менее четыре символа");
    adviceUsername.innerText = "(Вы ввели менее четырех символов)*".toUpperCase();
    adviceUsername.style.color = "darkred";
    inputUsernameElement.style.borderColor = "red";
}

function outputValidUsernameMessage() {
    console.log("Вы ввели 4 и более символа");
    adviceUsername.innerText = "(Введите от 4 до 20 символов)*";
    adviceUsername.style.color = "whitesmoke";
    inputUsernameElement.style.borderColor = "deepskyblue";
}

function limitPasswordLength(event) {
    if (inputPasswordElement.value.length > 24 &&
        event.code !== 'Backspace' &&
        event.code !== 'Delete') {
        event.preventDefault();
    }
}

function validatePassword() {
    if (inputPasswordElement.value.length < 6) {
        outputInvalidPasswordMessage();
        isPasswordValid = false;
    } else {
        outputValidPasswordMessage();
        isPasswordValid = true;
    }
}

function outputInvalidPasswordMessage() {
    console.log("Вы ввели менее 6 символа");
    advicePassword.innerText = "(Вы ввели менее шести символов)*".toUpperCase();
    advicePassword.style.color = "darkred";
    inputPasswordElement.style.borderColor = "red";
}

function outputValidPasswordMessage() {
    console.log("Вы ввели 4 и более символа");
    advicePassword.innerText = "(Введите от 4 до 25 символов)*";
    advicePassword.style.color = "whitesmoke";
    inputPasswordElement.style.borderColor = "deepskyblue";
}

function limitRepeatPasswordLength(event) {
    if (inputRepeatPasswordElement.value.length > 24 &&
        event.code !== 'Backspace' &&
        event.code !== 'Delete') {
        event.preventDefault();
    }
}

function validateRepeatPassword() {
    if (inputPasswordElement.value !== inputRepeatPasswordElement.value) {
        outputInvalidRepeatPasswordMessage();
        isRepeatPasswordValid = false;
    } else {
        outputValidRepeatPasswordMessage();
        isRepeatPasswordValid = true;
    }
}

function outputInvalidRepeatPasswordMessage() {
    console.log("Пароли не совпадают");
    adviceRepeatPassword.innerText = "Пароли не совпадают!".toUpperCase();
    adviceRepeatPassword.style.color = "darkred";
    inputRepeatPasswordElement.style.borderColor = "red";
}

function outputValidRepeatPasswordMessage() {
    console.log("Пароли совпадают");
    adviceRepeatPassword.innerText = "Пароль совпадает!".toUpperCase();
    adviceRepeatPassword.style.color = "greenyellow";
    inputRepeatPasswordElement.style.borderColor = "deepskyblue";
}

function validateForm(event) {
    if (!isUsernameValid || !isPasswordValid || !isRepeatPasswordValid) {
        event.preventDefault();
    }
    if (!isUsernameValid) {
        validateUsername();
    }
    if (!isPasswordValid) {
        validatePassword();
    }
    if (!isRepeatPasswordValid && inputPasswordElement.value.length > 0) {
        validateRepeatPassword()
    }
}

inputUsernameElement.addEventListener("input", validateUsername);
inputUsernameElement.addEventListener("keydown", limitUsernameLength);

inputPasswordElement.addEventListener("input", validatePassword);
inputPasswordElement.addEventListener("keydown", limitPasswordLength);

inputRepeatPasswordElement.addEventListener("keydown", limitRepeatPasswordLength);
inputRepeatPasswordElement.addEventListener("input", validateRepeatPassword);

registrationFormElement.addEventListener("submit", validateForm);