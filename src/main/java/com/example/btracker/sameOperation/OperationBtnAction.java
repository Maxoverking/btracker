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

    public static void showButtonsMonthAction (Text titleIncome,Text titleFood,Text  titleHouse,Text titleShopping,
        Text titleTransport,Text titleEntertainment,Text titleOther,Text outputIncome, Text outputFood, Text outputHouse,
                                               Text outputShopping, Text outputTransport, Text outputEntertainment,
                                               Text outputOther,
                                               String buttonText,
                                               Map<String, List<String>> budgetByMonth) {

        for (String month : budgetByMonth.keySet()) {
            if(month.equalsIgnoreCase(buttonText)){
                List<String> list = budgetByMonth.get(month);


                for(String value : list) {
                    String[] parts = value.split("=");

// Получаем название переменной
                    String category = parts[0];

// Получаем значение переменной
                    String expencies = parts[1];
                    switch (category) {
                        case "INCOME" -> {titleIncome.setText(category);
                            outputIncome.setText(expencies+ " € ");}
                        case "FOOD" -> {
                            titleFood.setText(category);
                            outputFood.setText(expencies);
                        }
                        case "HOUSE" -> {
                            titleHouse.setText(category);
                            outputHouse.setText(expencies);
                            ;
                        }
                        case "SHOPPING" -> {
                            titleShopping.setText(category);
                            outputShopping.setText(expencies);
                            ;
                        }
                        case "TRANSPORT" -> {
                            titleTransport.setText(category);
                            outputTransport.setText(expencies);
                            ;
                        }
                        case "ENTERTAINMENT" -> {
                            titleEntertainment.setText(category);
                            outputEntertainment.setText(expencies);
                            ;
                        }
                        case "OTHER" -> {
                            titleOther.setText(category);
                            outputOther.setText(expencies);
                            ;
                        }
                        default -> {
                        }
                    }

//                    switch (category) {
//                        case "INCOME" -> outputIncome.setText(expencies+ " € ");
//                        case "FOOD" -> outputFood.setText(expencies+ " € ");
//                        case "HOUSE" -> outputHouse.setText(expencies+ " € ");
//                        case "SHOPPING" -> outputShopping.setText(expencies+ " € ");
//                        case "TRANSPORT" -> outputTransport.setText(expencies+" € ");
//                        case "ENTERTAINMENT" -> outputEntertainment.setText(expencies+ " € ");
//                        case "OTHER" -> outputOther.setText(expencies+ " € ");
//                        default -> {
//                            return;
//                        }
//                    }
                }
            }
        }
    }
}


