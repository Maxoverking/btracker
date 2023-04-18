package com.example.btracker;

import com.example.btracker.exception.CustomException;

public class AddMoney {
    static final String errorReturnMoney = "Вы не можете вернуть такую сумму";

    /**
     * Метод возвращает общую сумму расходов по категории
     *
     * @param price - новая трата по категории
     * @param budget - текущая сумма расходов по категории
     * @return - общая сумма расходов по категории
     */
    public static int addMoney(int price, int budget) {
        if (price > 0) {
            return price + budget;
        } else {
            throw new CustomException(errorReturnMoney);
        }
    }
//            if (priceForFood < 0) {
//        throw new NumberFormatException();
//    }
//    budgetFood += priceForFood;
}

