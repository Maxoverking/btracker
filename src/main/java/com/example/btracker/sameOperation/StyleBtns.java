package com.example.btracker.sameOperation;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StyleBtns {

    /**
     * Метод, отвечающий за видимость кнопки Show и цвет кнопки Month
     *
     * @param buttonShow кнопка Show
     * @param buttonMonth кнопка с названием месяца
     * @param outputError поле вывода для ошибки
     * @param inputMonth поле ввода для названия месяца
     */
    public static void styleButtonsMonthAndShow(Button buttonShow, Button buttonMonth, Text outputError,
                                                 TextField inputMonth) {
        outputError.setText("");
        inputMonth.setText("");
        buttonShow.setText("Show");
        buttonShow.setVisible(true);
        buttonMonth.setStyle("-fx-background-color: #FF8034;");
        buttonMonth.setDisable(false);
    }

    /**
     * Метод, отвечающий за стиль кнопок месяц и сортировка
     *
     * @param buttonMonth кнопка с названием месяца
     * @param sortText текст кнопок для сортировки
     * @param sortUp кнопка для сортировки по возрастанию
     * @param sortDown кнопка для сортировки по убыванию
     */

    public static void styleButtonsMonthAndSort(Button buttonMonth, Text sortText, Button sortUp,
                                        Button sortDown) {
        buttonMonth.setDisable(false);
        buttonMonth.setStyle("");
        sortText.setVisible(true);
        sortUp.setVisible(true);
        sortDown.setVisible(true);
        sortUp.setText("↑");
        sortDown.setText("↓");
    }
}
