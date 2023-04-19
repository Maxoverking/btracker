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
     * @param budgetByMonth - Map, в которой записаны доходы и расходы по месяцам
     */

    public static void showButtonsMonthAction (Text outputIncome, Text outputFood, Text outputHouse,
                                               Text outputShopping, Text outputTransport, Text outputEntertainment,
                                               Text outputOther,
                                               String buttonText,
                                               Map<String, List<Map<String,Integer>>> budgetByMonth) {

        for (String month : budgetByMonth.keySet()) {
            if(month.equalsIgnoreCase(buttonText)){
                List<Map<String, Integer>> list = budgetByMonth.get(month);

                for(String key : list.get(0).keySet()) {
                    switch (key) {
                        case "INCOME" -> outputIncome.setText(list.get(0).get(key) + " € ");
                        case "FOOD" -> outputFood.setText(list.get(0).get(key) + " € ");
                        case "HOUSE" -> outputHouse.setText(list.get(0).get(key) + " € ");
                        case "SHOPPING" -> outputShopping.setText(list.get(0).get(key) + " € ");
                        case "TRANSPORT" -> outputTransport.setText(list.get(0).get(key) + " € ");
                        case "ENTERTAINMENT" -> outputEntertainment.setText(list.get(0).get(key) + " € ");
                        case "OTHER" -> outputOther.setText(list.get(0).get(key) + " € ");
                        default -> {
                            return;
                        }
                    }
                }
            }
        }
    }
}


