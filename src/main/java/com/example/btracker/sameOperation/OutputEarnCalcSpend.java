package com.example.btracker.sameOperation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javafx.scene.text.Text;

public class OutputEarnCalcSpend {

  public static void calcEarnAndSpendForMonth(Map<String, List<Integer>> budgetByMonth,
      String buttonText, Text earn, Text spend) {

    int totalSpend = 0;
    for (String month : budgetByMonth.keySet()) {
      if(month.equalsIgnoreCase(buttonText)){
        earn.setText(budgetByMonth.get(month).get(0)+"");

//      System.out.println( "Результат "+ month +" = "+budgetByMonth.get(month));

        for (int j = 1; j <budgetByMonth.get(month).size() ; j++) {
          totalSpend+= budgetByMonth.get(month).get(j);
      }
      }
    }
    spend.setText(totalSpend+"");

  }

}
