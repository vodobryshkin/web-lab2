import {toast} from "./toast.js";

const NUMBER_REGEX = /^-?\d*.?\d+$/;

const IS_NOT_A_NUMBER_CODE = "IS_NOT_A_NUMBER";
const NUMBER_IS_OUT_OF_RANGE_CODE = "NUMBER_IS_OUT_OF_RANGE";
const BLANK_IS_EMPTY_CODE = "BLANK_IS_EMPTY";
const IS_NUMBER_CODE = "IS_NUMBER";

export function validateNumbers(x, y, r) {
    let valX = validateX(x);
    let valY = validateY(y);
    let valR = validateR(r);

    if (typeof valX === "boolean" && typeof valY === "boolean" && typeof valR === "boolean") {
        return true;
    }

    switch (valX) {
        case IS_NOT_A_NUMBER_CODE:
            toast("X is not a number.");
            return false;

        case NUMBER_IS_OUT_OF_RANGE_CODE:
            toast("X is out of range (-5, 3).");
            return false;

        case BLANK_IS_EMPTY_CODE:
            toast("X input is empty.")
            return false;

        default:
            break
    }

    switch (valY) {
        case IS_NOT_A_NUMBER_CODE:
            toast("Y is not a number.");
            return false;

        case NUMBER_IS_OUT_OF_RANGE_CODE:
            toast("Y is out of range.");
            return false;

        case BLANK_IS_EMPTY_CODE:
            toast("Y input is empty.")
            return false

        default:
            break
    }

    switch (valR) {
        case IS_NOT_A_NUMBER_CODE:
            toast("R is not a number.");
            return false;

        case NUMBER_IS_OUT_OF_RANGE_CODE:
            toast("R is out of range.");
            return false;

        case BLANK_IS_EMPTY_CODE:
            toast("R input is empty.")
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

    if (potIsNumber === IS_NUMBER_CODE) {
        let number = Number(potNumber);

        if (number < Number("-5") || number > Number("3")) {
            return NUMBER_IS_OUT_OF_RANGE_CODE;
        }

        return true;
    }

    return potIsNumber;
}

function validateY(potNumber) {
    let potIsNumber = isNumber(potNumber);

    if (potIsNumber === IS_NUMBER_CODE) {
        let number = Number(potNumber);
        let yBorders = ["-2", "-1.5", "-1", "-0.5", "0", "0.5", "1", "1.5", "2"]

        for (let i = 0; i < yBorders.length; i++) {
            let yGr = Number(yBorders[i]);

            if (number === yGr) {
                return true;
            }
        }

        return NUMBER_IS_OUT_OF_RANGE_CODE;
    }

    return potIsNumber;
}

export function validateR(potNumber) {
    let potIsNumber = isNumber(potNumber);

    if (potIsNumber === IS_NUMBER_CODE) {
        let number = Number(potNumber);
        let rBorders = ["1", "1.5", "2", "2.5", "3"]

        for (let i = 0; i < rBorders.length; i++) {
            let rGr = Number(rBorders[i]);

            if (number === rGr) {
                return true;
            }
        }

        return NUMBER_IS_OUT_OF_RANGE_CODE;
    }

    return potIsNumber;
}