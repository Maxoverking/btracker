package com.example.btracker.sameOperation;

import javafx.scene.text.Text;
import java.util.List;
import java.util.Map;

public class OperationBtnAction {


    /**
     * Метод, выводящий на экран текущий общий бюджет и бюджет по категории после нажатия на кнопку ADD
     *
     * @param outputFix      вывод общего бюджета
     * @param outputCategory вывод бюджета по категории
     * @param outputError    вывод ошибки
     * @param budget         общий бюджет
     * @param budgetForCategory бюджет по категории
     */

    public static void showButtonsAction(Text outputFix, Text outputCategory, Text outputError,
                                         int budget, int budgetForCategory) {
        outputFix.setText("BUDGET  "+budget + " € ");
        outputCategory.setText(budgetForCategory + " € ");
        outputError.setText("");
    }

    /**
     * Метод, который по нажатию кнопки SHOW выводит все доходы и расходы за выбранный месяц на экран
     *
     * @param outputIncome        вывод категории Income
     * @param outputFood          вывод расходов в категории Food
     * @param outputHouse         вывод расходов в категории House
     * @param outputShopping      вывод расходов в категории Shopping
     * @param outputTransport     вывод расходов в категории Transport
     * @param outputEntertainment вывод расходов в категории Entertainment
     * @param outputOther         вывод расходов в категории Other
     * @param budgetByMonth       Map, в которой записаны доходы и расходы по месяцам
     */

    public static void showButtonsMonthAction(Text titleIncome, Text titleFood, Text titleHouse, Text titleShopping,
                                              Text titleTransport, Text titleEntertainment, Text titleOther, Text outputIncome,
                                              Text outputFood, Text outputHouse,
                                              Text outputShopping, Text outputTransport, Text outputEntertainment,
                                              Text outputOther,
                                              String buttonText,
                                              Map<String, List<String>> budgetByMonth) {

        for (String month : budgetByMonth.keySet()) {
            if (month.equalsIgnoreCase(buttonText)) {
                List<String> list = budgetByMonth.get(month);

                for (String value : list) {
                    String[] parts = value.split("=");

                    String category = parts[0];// Получаем название переменной

                    String expenses = parts[1]; // Получаем значение переменной
                    switch (category) {
                        case "INCOME" -> {
                            titleIncome.setText(category);
                            outputIncome.setText(expenses + " € ");
                        }
                        case "FOOD" -> {
                            titleFood.setText(category);
                            outputFood.setText(expenses  + " € ");
                        }
                        case "HOUSE" -> {
                            titleHouse.setText(category);
                            outputHouse.setText(expenses  + " € ");
                        }
                        case "SHOPPING" -> {
                            titleShopping.setText(category);
                            outputShopping.setText(expenses  + " € ");
                        }
                        case "TRANSPORT" -> {
                            titleTransport.setText(category);
                            outputTransport.setText(expenses  + " € ");
                        }
                        case "ENTERTAINMENT" -> {
                            titleEntertainment.setText(category);
                            outputEntertainment.setText(expenses  + " € ");
                                                    }
                        case "OTHER" -> {
                            titleOther.setText(category);
                            outputOther.setText(expenses  + " € ");
                        }
                        default -> {
                        }
                    }
                }
            }
        }
    }
}


