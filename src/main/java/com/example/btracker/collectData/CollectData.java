package com.example.btracker.collectData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectData {


    public static List<String> collectData (
                                            int incomeValue,int foodValue,int houseValue,
                                            int shoppingValue, int transportValue,int entertainmentValue,
                                            int otherValue) {
        List<String> valuesAllCategory = new ArrayList<>();
//        valuesAllCategory.add(INCOME = incomeValue,foodValue,houseValue, shoppingValue,
//                transportValue,entertainmentValue, otherValue));
        valuesAllCategory.add( "INCOME"+"="+incomeValue);
        valuesAllCategory.add("FOOD"+"="+foodValue);
        valuesAllCategory.add("HOUSE"+"="+houseValue);
        valuesAllCategory.add("SHOPPING"+"="+shoppingValue);
        valuesAllCategory.add("TRANSPORT"+"="+transportValue);
        valuesAllCategory.add("ENTERTAINMENT"+"="+entertainmentValue);
        valuesAllCategory.add("OTHER"+"="+otherValue);


        return valuesAllCategory;
    }

//    public static Map<String, Integer> categoryBudget (  int incomeValue,int foodValue,int houseValue,
//                                                         int shoppingValue, int transportValue,int entertainmentValue,
//                                                         int otherValue) {
//        Map <String, Integer> map = new HashMap<>();
//        map.put("INCOME", incomeValue);
//        map.put("FOOD", foodValue);
//        map.put("HOUSE", houseValue);
//        map.put("SHOPPING", shoppingValue);
//        map.put("TRANSPORT", transportValue);
//        map.put("ENTERTAINMENT", entertainmentValue);
//        map.put("OTHER", otherValue);
//
//        return map;
//    }
}
