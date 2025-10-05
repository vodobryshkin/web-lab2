import {draw, DEFAULT_R_NAME} from "./canvas.js";

window.addEventListener("DOMContentLoaded", () => {
    const rSelect = document.getElementById("select-r");
    if (rSelect) {
        draw(String(rSelect));
    }

    draw(String(DEFAULT_R_NAME));
});