package com.example.btracker.sameOperation;

import java.util.List;
import java.util.Map;
import javafx.scene.text.Text;

public class OutputEarnCalcSpend {

  public static void calcEarnAndSpendForMonth(Map<String, List<Map<String, Integer>>> budgetByMonth,
      String buttonText, Text earn, Text spend) {

    int totalSpend = 0;
    for (String month : budgetByMonth.keySet()) {
      if(month.equalsIgnoreCase(buttonText)){
        List<Map<String, Integer>> list = budgetByMonth.get(month);

        for(String i : list.get(0).keySet()) {
          if (i.equalsIgnoreCase("INCOME")) {
            earn.setText(list.get(0).get(i) + "");
          } else {
            totalSpend += list.get(0).get(i);
          }
        }
      }
      spend.setText(totalSpend + "");
    }
  }
}


