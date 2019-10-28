"use strict";

var popupArea = document.querySelector(".registration-form__notification-area");
var popupSubmitButton = document.querySelector(".registration-form__notification-submit");

popupSubmitButton.addEventListener("click", enableRegistrationForm);

function preventRegistrationBySubmitButton(event) {
    event = event || window.event;
    event.preventDefault();
    enableRegistrationForm();
}

registrationFormElement.addEventListener("submit", preventRegistrationBySubmitButton);
registrationFormElement.removeEventListener("submit", validateForm);

function enableRegistrationForm() {
    showRegistrationForm();
    enableRegistrationSubmitEvent();
    registrationFormElement.addEventListener("submit", validateForm);
}

function showRegistrationForm() {
    popupArea.style.display = "none";
}

function enableRegistrationSubmitEvent() {
    registrationFormElement.removeEventListener("submit", preventRegistrationBySubmitButton);
}
