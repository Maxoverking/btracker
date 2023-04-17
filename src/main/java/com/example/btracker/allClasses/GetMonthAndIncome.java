package com.example.btracker.allClasses;

public class GetMonthAndIncome {
  private final String month;
  private final int income;

  public GetMonthAndIncome(String month, int income){
    this.month =month;
    this.income =income;
  }

  public String getMonth() {
    return month;
  }

  public int getIncome() {
    return income;
  }
}
