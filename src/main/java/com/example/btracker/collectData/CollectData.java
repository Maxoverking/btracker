package com.example.btracker.collectData;

import java.util.ArrayList;
import java.util.List;
public class CollectData {
//    Kласс, который  собирает данные со всех полей и сохранять их в List.
//    Аргументы - все поля и категорий.
//    switch
//    Map
//    создание List c данными для каждого месяца.
    public static List<Integer> collectData(int income,int food,int house,int shopping,int transport,int entertainment,int other) {
        List<Integer> valuesAllCategory = new ArrayList<>();
        valuesAllCategory.add(income);
        valuesAllCategory.add(food);
        valuesAllCategory.add(house);
        valuesAllCategory.add(shopping);
        valuesAllCategory.add(transport);
        valuesAllCategory.add(entertainment);
        valuesAllCategory.add(other);

        return valuesAllCategory;
    }
}
