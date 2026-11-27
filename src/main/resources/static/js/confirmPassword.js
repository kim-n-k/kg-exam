/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const passwordError = document.getElementById("passwordError");

function validatePassword() {

    if (confirmPassword.value === "") {
        passwordError.textContent = "";
        return;
    }

    if (password.value !== confirmPassword.value) {
        passwordError.textContent = "Passwords do not match!";
        passwordError.style.color = "red";
    } else {
        passwordError.textContent = "Passwords match!";
        passwordError.style.color = "green";
    }
}

password.addEventListener("input", validatePassword);
confirmPassword.addEventListener("input", validatePassword);

