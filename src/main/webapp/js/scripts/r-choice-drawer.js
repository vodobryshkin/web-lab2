import {validateR} from "./validation.js";
import {draw} from "./canvas.js";

const rChoiceInput = document.getElementById("select-r");

rChoiceInput.addEventListener('change', () => {redrawCanvas(rChoiceInput.value)});

function redrawCanvas(r) {
    if (typeof validateR(r) !== "string") {
        draw(Number(r));
        // drawPoints(Number(r));
    }
}