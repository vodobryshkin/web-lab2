import { validateNumbers } from "./validation.js";

const form = document.getElementById("task-form");

const kalash = new Audio(`${location.pathname.split('/')[1] ? '/' + location.pathname.split('/')[1] : ''}/static/audio/kalash.mp3`);
kalash.preload = 'auto';
kalash.volume = 1;

form.addEventListener("submit", (e) => {
    const x = document.getElementById('input-x').value;
    const y = document.getElementById('select-y').value;
    const r = document.getElementById('select-r').value;

    if (!validateNumbers(x, y, r)) {
        e.preventDefault();
        return;
    }

    e.preventDefault();

    kalash.currentTime = 0;
    kalash.play().catch(() => {});
    setTimeout(() => {
        form.submit();
    }, 400);
});
