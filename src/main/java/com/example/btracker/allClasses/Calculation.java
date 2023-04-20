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
     * Метод, возвращающий новый бюджет
     *
     * @param budget           бюджет
     * @param priceForCategory трата по категории
     * @return новый бюджет
     */
    public static int calculateIncome(int budget, int priceForCategory) {

        if (budget > 0 && priceForCategory <= budget) {
            budget = budget - priceForCategory;
            return budget;
        } else {
            throw new CustomException(errorIfMinus);
        }
    }

    /**
     * Метод, возвращающий новый бюджет после возврата
     *
     * @param income                 бюджет
     * @param priceForCategoryReturn возврат по категории
     * @return новый бюджет
     */
    public static int calculateIncomeReturn(int income, int priceForCategoryReturn) {
        income += priceForCategoryReturn;
        return income;
    }

    /**
     * Метод возвращает общую сумму расходов по категории
     *
     * @param price  - новая трата по категории
     * @param budget - текущая сумма расходов по категории
     * @return - общая сумма расходов по категории
     */
    public static int addMoney(int price, int budget, int income) {
        if (price > 0 && price <= income) {
            return price + budget;
        } else {
            throw new CustomException(errorSpendMoreBudget);
        }
    }

    /**
     * Метод, возвращающий разницу между текущим значением поля и вводимым значением
     *
     * @param amount      - расходы по текущей категории
     * @param priceReturn - количество денег, которые хотим вернуть
     * @return - разница между расходами по текущей категории и вводимым значением
     */
    public static int returnMoney(int amount, int priceReturn) {
        if (amount > 0 && priceReturn <= amount) {
            return amount - priceReturn;
        }
        throw new CustomException(errorReturnMoney);
    }

    /**
     * Метод считает сумму заработанных и потраченных денег за месяц
     *
     * @param budgetByMonth бюджет за месяц
     * @param buttonText    кнопка
     * @param earn          заработано
     * @param spend         потрачено
     */

    public static void calcEarnAndSpendForMonth(Map<String, List<String>> budgetByMonth,
                                                String buttonText, Text earn, Text spend) {

        int totalSpend = 0;
        for (String month : budgetByMonth.keySet()) {
            if (month.equalsIgnoreCase(buttonText)) {
                List<String> list = budgetByMonth.get(month);
                for (String getPrice : list) {
                    String[] parts = getPrice.split("=");
// Получаем название переменной
                    String category = parts[0];
// Получаем значение переменной
                    String expenses = parts[1];
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
