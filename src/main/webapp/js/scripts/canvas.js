import {validateR} from "./validation.js";

const rLength = 250;
export const DEFAULT_R_NAME = "R";

const canvas = document.getElementById("canvas");

export function draw(rName) {
    drawCoordinatePlane(rName);
    drawAreas();
}

function drawCoordinatePlane(rName) {
    const ctx = canvas.getContext("2d");

    ctx.clearRect(0, 0, canvas.width, canvas.height);

    ctx.strokeStyle = "black";
    ctx.lineCap = "round";
    ctx.lineWidth = 3;
    ctx.font = '20px Arial';
    ctx.fillStyle = 'black';

    let halfRName = rName === DEFAULT_R_NAME ? "R/2" : String(Number(rName) / 2);

    ctx.beginPath();
    ctx.moveTo(0, canvas.height / 2);
    ctx.lineTo(canvas.width, canvas.height / 2);
    ctx.moveTo(canvas.width / 2, 0);
    ctx.lineTo(canvas.width / 2, canvas.height);


    ctx.moveTo(canvas.width, canvas.height / 2);
    ctx.lineTo(canvas.width - 15, canvas.height / 2 - 7);
    ctx.moveTo(canvas.width, canvas.height / 2);
    ctx.lineTo(canvas.width - 15, canvas.height / 2 + 7);

    ctx.moveTo(canvas.width / 2, 0);
    ctx.lineTo(canvas.width / 2 - 7, 15);
    ctx.moveTo(canvas.width / 2, 0);
    ctx.lineTo(canvas.width / 2 + 7, 15);

    ctx.fillText("x", canvas.width - 10, canvas.height / 2 + 20)
    ctx.fillText("y", canvas.width / 2 + 12, 12)

    // x -r
    ctx.moveTo(canvas.width / 2 - rLength, canvas.height / 2 + 10);
    ctx.lineTo(canvas.width / 2 - rLength, canvas.height / 2 - 10);
    ctx.fillText(`-${rName}`, canvas.width / 2 - rLength - 14, canvas.height / 2 - 15)

    // x -r/2
    ctx.moveTo(canvas.width / 2 - rLength / 2, canvas.height / 2 + 10);
    ctx.lineTo(canvas.width / 2 - rLength / 2, canvas.height / 2 - 10);
    ctx.fillText(`-${halfRName}`, canvas.width / 2 - rLength / 2 - 24, canvas.height / 2 - 15)

    // x r/2
    ctx.moveTo(canvas.width / 2 + rLength / 2, canvas.height / 2 + 10);
    ctx.lineTo(canvas.width / 2 + rLength / 2, canvas.height / 2 - 10);
    ctx.fillText(`${halfRName}`, canvas.width / 2 + rLength / 2 - 14, canvas.height / 2 - 15)

    // x r
    ctx.moveTo(canvas.width / 2 + rLength, canvas.height / 2 + 10);
    ctx.lineTo(canvas.width / 2 + rLength, canvas.height / 2 - 10);
    ctx.fillText(`${rName}`, canvas.width / 2 + rLength - 7, canvas.height / 2 - 15)

    // y -r
    ctx.moveTo(canvas.width / 2 - 10, canvas.height / 2 + rLength);
    ctx.lineTo(canvas.width / 2 + 10, canvas.height / 2 + rLength);
    ctx.fillText(`-${rName}`, canvas.width / 2 + 14, canvas.height / 2 + rLength + 7)

    // y -r/2
    ctx.moveTo(canvas.width / 2 - 10, canvas.height / 2 + rLength / 2);
    ctx.lineTo(canvas.width / 2 + 10, canvas.height / 2 + rLength / 2);
    ctx.fillText(`-${halfRName}`, canvas.width / 2 + 14, canvas.height / 2 + rLength / 2 + 7)

    // y r/2
    ctx.moveTo(canvas.width / 2 - 10, canvas.height / 2 - rLength / 2);
    ctx.lineTo(canvas.width / 2 + 10, canvas.height / 2 - rLength / 2);
    ctx.fillText(`${halfRName}`, canvas.width / 2 + 14, canvas.height / 2 - rLength / 2 + 7)

    // y r
    ctx.moveTo(canvas.width / 2 - 10, canvas.height / 2 - rLength);
    ctx.lineTo(canvas.width / 2 + 10, canvas.height / 2 - rLength);
    ctx.fillText(`${rName}`, canvas.width / 2 + 14, canvas.height / 2 - rLength + 7)

    ctx.stroke();
    ctx.closePath();
}

function drawAreas() {
    const ctx = canvas.getContext("2d");
    ctx.fillStyle = "rgba(221,67,255,0.3)";

    ctx.beginPath();
    ctx.lineCap = "round";
    ctx.lineWidth = 1;

    ctx.rect(canvas.width / 2, canvas.height / 2 - rLength, rLength / 2, rLength)

    ctx.moveTo(canvas.width / 2, canvas.height / 2);
    ctx.lineTo(canvas.width / 2 - rLength, canvas.height / 2);
    ctx.lineTo(canvas.width / 2, canvas.height / 2 + rLength / 2);
    ctx.lineTo(canvas.width / 2, canvas.height / 2);

    ctx.arc(canvas.width / 2, canvas.height / 2, rLength / 2, 1.5 * Math.PI, 2.5 * Math.PI, false);

    ctx.fill();
    ctx.closePath();
}

export function drawPoint(x, y, r) {
    const ctx = canvas.getContext("2d");
    ctx.fillStyle = "#ae43ff";

    const unit = rLength / r;
    const cx = canvas.width / 2;
    const cy = canvas.height / 2;

    const px = x * unit + cx;
    const py = -y * unit + cy;

    ctx.beginPath();
    ctx.arc(px, py, 5, 0, 2 * Math.PI);
    ctx.fill();
    ctx.closePath();
}

function getCanvasCoords(evt) {
    const rect = canvas.getBoundingClientRect();
    const cssX = (evt.clientX ?? evt.touches?.[0].clientX) - rect.left;
    const cssY = (evt.clientY ?? evt.touches?.[0].clientY) - rect.top;
    const scaleX = canvas.width  / rect.width;
    const scaleY = canvas.height / rect.height;
    return { x: cssX * scaleX, y: cssY * scaleY };
}

canvas.addEventListener("click", (e) => getClickedCoordinates(e));

function getClickedCoordinates(e) {
    const { x, y } = getCanvasCoords(e);

    const r = document.getElementById('select-r').value;
    if (typeof validateR(r) === "string") {
        alert("R не выбран"); return;
    }

    const numR = Number(r);

    const unit = rLength / numR;
    const cx = canvas.width  / 2;
    const cy = canvas.height / 2;

    const correctX =  (x - cx) / unit;
    const correctY = -(y - cy) / unit;

    const form = document.getElementById('task-form');
    const params = new URLSearchParams({
        x: correctX.toFixed(3),
        y: correctY.toFixed(3),
        r: r,
        type: '"only_r"'
    });
    location.href = `${form.action}?${params.toString()}`;
}
