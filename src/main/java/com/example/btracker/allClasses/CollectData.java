package com.example.btracker.allClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectData {

//    Создание класса, который будет собирать данные со всех полей и сохранять их в List.
//    Аргументы - все поля и месяц.
//    switch
//    Map
//    Создание List c названием каждого месяца.

    public static Map<String, Integer> expenses = new HashMap<>();

    public static void main(String[] args) {
        // Map для хранения расходов по категориям и месяцам
        Map<String, List<Integer>> expenses = new HashMap<>();
        //expenses.put()

        // List для хранения названий месяцев
//        List<String> months= new ArrayList<>();
//        months.add("J");
//        months.add("F");
        List<Integer> valuesJanuary = new ArrayList<>();
        valuesJanuary.add(20);
        valuesJanuary.add(30);

//        switch (month)
//            case "January" ->

        List<Integer> valuesFebruary = new ArrayList<>();
        valuesFebruary.add(10);
        valuesFebruary.add(30);

        expenses.put("January", valuesJanuary);
        expenses.put("February", valuesFebruary);

        for (String i : expenses.keySet()) {
            System.out.println("key: " + i + " value: " + expenses.get(i));
        }
//        for (int i = 0; i < expenses.size(); i++) {
//
//        }


    }


}
