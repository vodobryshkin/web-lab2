import {validateNumbers} from "./validation.js";

const button = document.getElementById("confirm-btn");
button.addEventListener("click", sending);

async function sending() {
    const x = document.getElementById('input-x').value;
    const y = document.getElementById('select-y').value;
    const r = document.getElementById('select-r').value;

    if (validateNumbers(x, y, r)) {
        try {
            const response = await fetch(`/points?x=${x}&y=${y}&r=${r}`, {
                method: 'GET',
                headers: {'Content-Type': 'application/json'}
            });

            const result = await response.json();

            console.log(...result)

        } catch (error) {
            alert(error);
            return null;
        }
    }
}