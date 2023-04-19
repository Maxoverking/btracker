package com.example.btracker.correctMonth;

import com.example.btracker.exception.CustomException;
import java.util.Arrays;
import java.util.List;

public class CorrectMonth {
 private static final List<String> months = Arrays.asList(
      "january", "february", "march", "april", "may", "june",
      "july", "august", "september", "october", "november", "december"
  );
  public static String  correctMonth(String month) {
    if (month.isEmpty()) {
      throw new CustomException("Month is required");

    } else if (isMonthInList(month, months)) {
      return month;
    }
    else {
      throw new CustomException(" Entered uncorrect month ");
    }
  }
  public static boolean isMonthInList(String month, List<String> months) {
    return months.contains(month);
  }
}
