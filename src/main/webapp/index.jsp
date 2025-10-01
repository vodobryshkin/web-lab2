<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Лабораторная работа по веб-программированию #2</title>
        <meta charset="UTF-8">
    </head>
        <header class="header">
            <h1 class="header__element header__element_nsf">Добрышкин Владимир Александрович</h1>
            <h1 class="header__element header__element_group-number">P3207</h1>
            <h1 class="header__element header__element_variant">Вариант 853932</h1>
        </header>

        <section class="task-section">
            <form class="task-section__form task-form" id="task-form" method="get" action="">
                <ul class="task-from__input-list input-list">
                    <li class="input-list__element input-list__element-x">
                        <label class="task-form__label task-form__label_x" for="input-x">
                            Изменение X:
                            <input class="task-form__input-x" id="input-x" name="x"
                                   placeholder="Введите число от -5 до 3" type="text">
                        </label>
                    </li>

                    <li class="input-list__element input-list__element-y">
                        <label class="task-form__label task-form__label_y" for="select-y">
                            Изменение Y:
                            <select class="select__element-y" id="select-y" name="y" required>
                                <option value="" disabled selected hidden>...</option>
                                <option value="-2">-2</option>
                                <option value="-1.5">-1.5</option>
                                <option value="-1">-1</option>
                                <option value="-0.5">-0.5</option>
                                <option value="0">0</option>
                                <option value="0.5">0.5</option>
                                <option value="1">1</option>
                                <option value="1.5">1.5</option>
                                <option value="2">2</option>
                            </select>
                        </label>
                    </li>

                    <li class="input-list__element input-list__element-r">
                        <label class="task-form__label task-form__label_r" for="select-r">
                            Изменение R:
                            <select class="select__element-r" id="select-r" name="r" required>
                                <option value="" disabled selected hidden>...</option>
                                <option value="1">1</option>
                                <option value="1.5">1.5</option>
                                <option value="2">2</option>
                                <option value="2.5">2.5</option>
                                <option value="3">3</option>
                            </select>
                        </label>
                    </li>
                </ul>
                <button class="task-form__confirm-button" id="confirm-btn" type="submit">
                    Поставить точку
                </button>
            </form>
            <canvas class="canvas" id="canvas" width="600" height="600"></canvas>
        </section>

        <footer class="footer">

        </footer>

        <script src="js/scripts/validation.js" type="module"></script>
        <script src="js/scripts/main.js" type="module"></script>
        <script src="js/scripts/r-choice-drawer.js" type="module"></script>
</html>