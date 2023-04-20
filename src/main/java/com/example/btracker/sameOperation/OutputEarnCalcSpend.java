package com.example.btracker.sameOperation;

import java.util.List;
import java.util.Map;
import javafx.scene.text.Text;

public class OutputEarnCalcSpend {

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
                    String expencies = parts[1];
                    if (category.equalsIgnoreCase("INCOME")) {
                        earn.setText(expencies + "");
                    } else {
                        totalSpend += Integer.parseInt(expencies);
                    }
                }
            }
            spend.setText(totalSpend + "");
        }
    }
}
