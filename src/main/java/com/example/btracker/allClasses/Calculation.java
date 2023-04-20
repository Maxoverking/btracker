package com.example.btracker.allClasses;

import com.example.btracker.exception.CustomException;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;

import static com.example.btracker.MainController.errorIfMinus;

public class Calculation {
    static final String errorReturnMoney = "You can't return this amount";
    public static final String errorSpendMoreBudget = "You can't enter an amount greater than the budget";

    /**
     * Метод, возвращающий общий бюджет после добавления траты по одной из категорий
     *
     * @param budget           общий бюджет по всем категориям
     * @param priceForCategory новая трата по категории
     * @return новый общий бюджет
     */
    public static int calculateBudget(int budget, int priceForCategory) {
        if (budget > 0 && priceForCategory <= budget) {
            return budget - priceForCategory;
        } else {
            throw new CustomException(errorIfMinus);
        }
    }

    /**
     * Метод возвращает общую сумму расходов по одной категории
     *
     * @param budget  - общий бюджет по всем категориям
     * @param priceForCategory  - новая трата по категории
     * @param budgetForCategory - текущая сумма расходов по этой категории
     * @return - общая сумма расходов по категории
     */
    public static int addMoney(int priceForCategory, int budgetForCategory, int budget) {
        if (priceForCategory > 0 && priceForCategory <= budget) {
            return priceForCategory + budgetForCategory;
        } else {
            throw new CustomException(errorSpendMoreBudget);
        }
    }

    /**
     * Метод, возвращающий разницу между общим бюджетом и количеством денег для возврата по одной из категории
     *
     * @param budget                 общий бюджет по всем категориям
     * @param priceForCategoryReturn количество денег, которые хотим вернуть по выбранной категории
     * @return новый общий бюджет
     */
    public static int calculateBudgetReturn(int budget, int priceForCategoryReturn) {
        budget += priceForCategoryReturn;
        return budget;
    }


    /**
     * Метод, возвращающий разницу между бюджетом по одной из категорий
     * и введенной суммой, которую хотим вернуть
     *
     * @param budgetForCategory      - бюджет по одной из категорий
     * @param priceForCategoryReturn - количество денег, которые хотим вернуть
     * @return - новый бюджет по одной из категорий
     */
    public static int returnMoney(int budgetForCategory, int priceForCategoryReturn) {
        if (budgetForCategory > 0 && priceForCategoryReturn <= budgetForCategory) {
            return budgetForCategory - priceForCategoryReturn;
        }
        throw new CustomException(errorReturnMoney);
    }

    /**
     * Метод считает и выводит сумму заработанных и потраченных денег за месяц
     *
     * @param budgetByMonth общий бюджет за месяц
     * @param buttonText    кнопка с названием месяца
     * @param earn          доход за месяц
     * @param spend         общие расходы за месяц
     */

    public static void calcEarnAndSpendForMonth(Map<String, List<String>> budgetByMonth,
                                                String buttonText, Text earn, Text spend) {

        int totalSpend = 0;
        for (String month : budgetByMonth.keySet()) {
            if (month.equalsIgnoreCase(buttonText)) {
                List<String> list = budgetByMonth.get(month);
                for (String getPrice : list) {
                    String[] parts = getPrice.split("=");
                    String category = parts[0]; // Получаем название переменной
                    String expenses = parts[1]; // Получаем значение переменной
                    if (category.equalsIgnoreCase("INCOME")) {
                        earn.setText(expenses);
                    } else {
                        totalSpend += Integer.parseInt(expenses);
                    }
                }
            }
            spend.setText(String.valueOf(totalSpend));
        }
    }
}
