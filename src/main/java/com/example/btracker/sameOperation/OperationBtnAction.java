package com.example.btracker.sameOperation;

import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;

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

    /**
     * Метод, который по нажатию кнопки выводит доходы и расходы за выбранный месяц на экран
     * @param outputIncome - поле вывода для дохода
     * @param outputFood - поле вывода для категории расходов Food
     * @param outputHouse - поле вывода для категории расходов House
     * @param outputShopping - поле вывода для категории расходов Shopping
     * @param outputTransport - поле вывода для категории расходов Transport
     * @param outputEntertainment - поле вывода для категории расходов Entertainment
     * @param outputOther - поле вывода для категории расходов Other
     * @param incomeFix - переменная, в которой хранится доход за выбранный месяц
     * @param budgetByMonth - Map, в которой записаны доходы и расходы по месяцам
     * @param month - выбранный месяц
     */
    public static void showButtonsMonthAction (Text outputIncome, Text outputFood, Text outputHouse,
                                               Text outputShopping, Text outputTransport, Text outputEntertainment,
                                               Text outputOther,
                                               int incomeFix,
                                               Map<String, List<Integer>> budgetByMonth, String month) {
        outputIncome.setText(incomeFix + " € ");
        outputFood.setText(budgetByMonth.get(month).get(1) + " € ");
        outputHouse.setText(budgetByMonth.get(month).get(2) + " € ");
        outputShopping.setText(budgetByMonth.get(month).get(3) + " € ");
        outputTransport.setText(budgetByMonth.get(month).get(4) + " € ");
        outputEntertainment.setText(budgetByMonth.get(month).get(5) + " € ");
        outputOther.setText(budgetByMonth.get(month).get(6) + " € ");

    }
}


