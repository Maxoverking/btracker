package com.example.btracker.sameOperation;

import javafx.scene.text.Text;

public class OperationBtnAction {
    /**
     *
     * @param outputFix      текст income + " € "
     * @param outputCategory текст бюджет по категории
     * @param outputError    ошибка
     * @param income         бюджет
     * @param budgetCategory бюджет по категории
     */
    public static void showButtonsAction(Text outputFix, Text outputCategory, Text outputError,
                                         int income, int budgetCategory) {
        outputFix.setText(income + " € ");
        outputCategory.setText(budgetCategory + " € ");
        outputError.setText("");
    }
}


