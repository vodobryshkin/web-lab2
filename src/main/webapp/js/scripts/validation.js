import Decimal from "../libs/decimal.js/decimal.mjs";

const NUMBER_REGEX = /^-?\d*.?\d+$/;

const IS_NOT_A_NUMBER_CODE = "IS_NOT_A_NUMBER";
const NUMBER_IS_OUT_OF_RANGE_CODE = "NUMBER_IS_OUT_OF_RANGE";
const BLANK_IS_EMPTY_CODE = "BLANK_IS_EMPTY";
const IS_NUMBER_CODE = "IS_NUMBER";

const button = document.getElementById("confirm-btn");
button.addEventListener("click", validation);

function validation() {
    const x = document.getElementById('input-x').value;
    const y = document.getElementById('select-y').value;
    const r = document.getElementById('select-r').value;

    if (validateNumbers(x, y, r)) {
        const form = document.getElementById("task-form");
        form.requestSubmit();
    }
}

function validateNumbers(x, y, r) {
    let valX = validateX(x);
    let valY = validateY(y);
    let valR = validateR(r);

    if (typeof valX === "boolean" && valY === "boolean" && valR === "boolean") {
        return true;
    }

    switch (valX) {
        case IS_NOT_A_NUMBER_CODE:
            alert("X не является числом.");
            return false;

        case NUMBER_IS_OUT_OF_RANGE_CODE:
            alert("X выходит за границы (3, 5).");
            return false;

        case BLANK_IS_EMPTY_CODE:
            alert("Поля ввода X пустое.")
            return false

        default:
            break
    }

    switch (valY) {
        case IS_NOT_A_NUMBER_CODE:
            alert("Y не является числом.");
            return false;

        case NUMBER_IS_OUT_OF_RANGE_CODE:
            alert("Y не равен ни одному из заданных значений.");
            return false;

        case BLANK_IS_EMPTY_CODE:
            alert("Y не выбран.")
            return false

        default:
            break
    }

    switch (valR) {
        case IS_NOT_A_NUMBER_CODE:
            alert("R не является числом.");
            return false;

        case NUMBER_IS_OUT_OF_RANGE_CODE:
            alert("R не равен ни одному из заданных значений.");
            return false;

        case BLANK_IS_EMPTY_CODE:
            alert("R не выбран.")
            return false

        default:
            break
    }
}

function isNumber(potNumber) {
    if (potNumber.length === 0 || potNumber === "...") {
        return BLANK_IS_EMPTY_CODE;
    }

    if (!NUMBER_REGEX.test(potNumber)) {
        return IS_NOT_A_NUMBER_CODE;
    }

    return IS_NUMBER_CODE;
}


function validateX(potNumber) {
    let potIsNumber = isNumber(potNumber);

    if (potNumber === IS_NUMBER_CODE) {
        let number = new Decimal(potNumber);

        if (number.lt(new Decimal("-5")) || number.gt(new Decimal("3"))) {
            return NUMBER_IS_OUT_OF_RANGE_CODE;
        }

        return true;
    }

    return potIsNumber;
}

function validateY(potNumber) {
    let potIsNumber = isNumber(potNumber);

    if (potNumber === IS_NUMBER_CODE) {
        let number = new Decimal(potNumber);
        let yBorders = ["-2", "-1.5", "-1", "-0.5", "0", "0.5", "1", "1.5", "2"]

        for (let i = 0; i < yBorders.length; i++) {
            let yGr = new Decimal(yBorders[i]);

            if (number.eq(yGr)) {
                return true;
            }
        }

        return NUMBER_IS_OUT_OF_RANGE_CODE;
    }

    return potIsNumber;
}

function validateR(potNumber) {
    let potIsNumber = isNumber(potNumber);

    if (potNumber === IS_NUMBER_CODE) {
        let number = new Decimal(potNumber);
        let rBorders = ["1", "1.5", "2", "2.5", "3"]

        for (let i = 0; i < rBorders.length; i++) {
            let rGr = new Decimal(rBorders[i]);

            if (number.eq(rGr)) {
                return true;
            }
        }

        return NUMBER_IS_OUT_OF_RANGE_CODE;
    }

    return potIsNumber;
}