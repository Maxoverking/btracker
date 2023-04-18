package com.example.btracker;

import com.example.btracker.exception.CustomException;

public class MoneyReturn {

    static final String errorReturnMoney = "Нельзя ничего вернуть";

    /**
     * Метод, возвращающий разницу между текущим значением поля и вводимым значением
     * @param amount - расходы по текущей категории
     * @param priceReturn - количество денег, которые хотим вернуть
     * @return - разница между расходами по текущей категории и вводимым значением
     */
    public static int moneyReturn(int amount, int priceReturn) {
        if (amount > 0 && priceReturn <= amount) {
            return amount - priceReturn;
        } else {
            throw new CustomException(errorReturnMoney);
        }
    }
}