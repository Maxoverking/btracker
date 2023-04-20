package com.example.btracker.correctMonth;

import com.example.btracker.exception.CustomException;

import java.util.Arrays;
import java.util.List;

public class CorrectMonth {

    private static final List<String> months = Arrays.asList(
            "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december");

    /**
     * Метод возвращает название месяца или выдает ошибку, если месяц введен некорректно
     * или поле пустое.
     *
     * @param month месяц
     * @return возвращает название месяца
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
     * Метод возвращает данные, содержится ли в списке месяцев введенный месяц.
     *
     * @param month месяц
     * @param months список месяцев
     * @return возвращает данные, содержится ли в списке месяцев введенный месяц
     */

    public static boolean isMonthInList(String month, List<String> months) {
        return months.contains(month);
    }
}
