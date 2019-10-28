"use strict";

var popupArea = document.querySelector(".registration-form__notification-area");
var popupText = document.querySelector(".registration-form__notification-message");
var popupSubmitButton = document.querySelector(".registration-form__notification-submit");


popupSubmitButton.addEventListener("click", enableRegistrationForm);

function preventRegistrationBySubmitButton(event) {
    event = event || window.event;
    console.log("preventRegistrationBySubmitButton");
    console.log(event);
    event.preventDefault();
    enableRegistrationForm();
}

registrationFormElement.addEventListener("submit", preventRegistrationBySubmitButton);

function enableRegistrationForm() {
    console.log('enableRegistrationForm');
    showRegistrationForm();
    enableRegistrationSubmitEvent();
}

function showRegistrationForm() {
    popupArea.style.display = "none";
}

function enableRegistrationSubmitEvent() {
    console.log("enableRegistrationSubmitEvent");
    registrationFormElement.removeEventListener("submit", preventRegistrationBySubmitButton);
}
