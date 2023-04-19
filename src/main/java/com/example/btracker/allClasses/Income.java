package com.example.btracker.allClasses;

public class Income {

    /**
     *
     * @param income бюджет
     * @param priceForCategory трата по категории
     * @return новый бюджет
     */
    public static int calculateIncome (int income, int priceForCategory){
        income = income - priceForCategory;
        return income;
    }

    /**
     *
     * @param income бюджет
     * @param priceForCategoryReturn возврат по категории
     * @return новый бюджет
     */
    public static int calculateIncomeReturn (int income, int priceForCategoryReturn){
        income += priceForCategoryReturn;
        return income;
    }

}
