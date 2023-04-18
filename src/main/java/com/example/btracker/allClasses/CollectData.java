package com.example.btracker.allClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectData {

//    Создание класса, который будет собирать данные со всех полей и сохранять их в List.
//            Аргументы - все поля и месяц.
//            switch
//    Map
//    Создание List c названием каждого месяца.


    // Map для хранения расходов по категориям и месяцам
    Map<String, Map<String, Integer>> expenses = new HashMap<>();

    // List для хранения названий месяцев
    ArrayList<String> months = new ArrayList<>();


}
