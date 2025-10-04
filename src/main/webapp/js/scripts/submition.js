import { validateNumbers } from "./validation.js";

const form = document.getElementById("task-form");

form.addEventListener("submit", (e) => {
    const x = document.getElementById('input-x').value;
    const y = document.getElementById('select-y').value;
    const r = document.getElementById('select-r').value;

    if (!validateNumbers(x, y, r)) {
        e.preventDefault();
    }
});
