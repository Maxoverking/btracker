package com.example.btracker.allClasses;

import java.util.ArrayList;
import java.util.List;

public class GetBudget {
  public static List<Integer> budget = new ArrayList<>();



//  public static List<Integer> getBudget(String num){
//    budget.add(Integer.parseInt(num));
//    return budget;
//  }
  public static int getBudget(String num){
    return Integer.parseInt(num);
  }

}
