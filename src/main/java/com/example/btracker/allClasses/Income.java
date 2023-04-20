package com.example.btracker.allClasses;

import com.example.btracker.exception.CustomException;
import static com.example.btracker.MainController.errorIfMinus;

public class Income {

    /**
     * @param income           бюджет
     * @param priceForCategory трата по категории
     * @return новый бюджет
     */
    public static int calculateIncome(int income, int priceForCategory) {

        if (income > 0 && priceForCategory <= income) {
            income = income - priceForCategory;
            return income;
        } else {
            throw new CustomException(errorIfMinus);
        }
    }

    /**
     * @param income                 бюджет
     * @param priceForCategoryReturn возврат по категории
     * @return новый бюджет
     */
    public static int calculateIncomeReturn(int income, int priceForCategoryReturn) {
        income += priceForCategoryReturn;
        return income;
    }
}
