package com.example.btracker.sortingData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortingData {
    public static List<String> convertMap(Map<String, List<String>> budgetByMonth,
                                          String currentMonth, boolean isSortUpOrDown) {
        List<String> listFromDataForSort = new ArrayList<>();
        for (String month : budgetByMonth.keySet()) {
            if (month.equalsIgnoreCase(currentMonth)) {
                List<String> list = budgetByMonth.get(month);
                for (String item : list) {
                    if (!item.startsWith("INCOME")) {
                        listFromDataForSort.add(item);
                    }
                }
                listFromDataForSort.sort((s1, s2) -> {
                    int value1 = Integer.parseInt(s1.split("=")[1]);
                    int value2 = Integer.parseInt(s2.split("=")[1]);
                    return isSortUpOrDown ? Integer.compare(value2, value1) : Integer.compare(value1, value2);
                });
                return listFromDataForSort;
            }
        }
        return null;
    }
}
