package com.example.btracker;

import com.example.btracker.exception.CustomException;

public class AddMoney {
    //static final String errorReturnMoney = "Вы не можете вернуть такую сумму";
    public static final String errorSpendMoreBudget = "Нельзя внести сумму больше бюджета";

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
//            if (priceForFood < 0) {
//        throw new NumberFormatException();
//    }
//    budgetFood += priceForFood;
}

