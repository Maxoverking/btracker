package com.example.btracker;

import com.example.btracker.exception.CustomException;

public class ReturnMoney {

    static final String errorReturnMoney = "Вы не можете вернуть такую сумму";

    /**
     * Метод, возвращающий разницу между текущим значением поля и вводимым значением
     * @param amount - расходы по текущей категории
     * @param priceReturn - количество денег, которые хотим вернуть
     * @return - разница между расходами по текущей категории и вводимым значением
     */
    public static int returnMoney(int amount, int priceReturn) {
        if (amount > 0 && priceReturn <= amount) {
            return amount - priceReturn;
        } else {
            throw new CustomException(errorReturnMoney);
        }
    }
}
