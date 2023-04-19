package com.example.btracker.collectData;

import java.util.ArrayList;
import java.util.List;
public class CollectData {
    /**
     * Метод, собирающий данные по каждому месяцу в лист и возвращающий его
     * @param income - данные по доходу за определенный месяц
     * @param food - данные по расходу в категории Food за определенный месяц
     * @param house - данные по расходу в категории House за определенный месяц
     * @param shopping  - данные по расходу в категории Shopping за определенный месяц
     * @param transport  - данные по расходу в категории Transport за определенный месяц
     * @param entertainment  - данные по расходу в категории Entertainment за определенный месяц
     * @param other  - данные по расходу в категории Other за определенный месяц
     * @return - лист с данными по доходам и расходом за определенный месяц
     */

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
