package com.example.btracker.correctMonth;

import com.example.btracker.exception.CustomException;

import java.util.Arrays;
import java.util.List;

public class CorrectMonth {

    private static final List<String> months = Arrays.asList(
            "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december");

    /**
     * Метод проверяет корректность ввода месяца и возвращает его, если месяц введен правильно.
     * Если поле пустое или месяц введен некорректно, то возвращает соответствующую ошибку.
     *
     * @param month введенный месяц
     * @return  название месяца
     */

    public static String correctMonth(String month) {
        if (month.isEmpty()) {
            throw new CustomException("Month name required");
        } else if (isMonthInList(month, months)) {
            return month;
        } else {
            throw new CustomException("Incorrect month entered");
        }
    }

    /**
     * Метод проверяет наличие введенного месяца в списке месяцев
     *
     * @param month введенный месяц
     * @param months список месяцев
     * @return возвращает true/false в зависимости от наличия введенного месяца в списке месяцев.
     */

    public static boolean isMonthInList(String month, List<String> months) {
        return months.contains(month);
    }
}
