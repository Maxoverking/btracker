package com.example.btracker.collectData;

import java.util.ArrayList;
import java.util.List;

public class CollectData {

    /**
     * Метод собирает данные по категориям и записывает в лист
     *
     * @param incomeValue сумма доходов
     * @param foodValue траты по категории Food
     * @param houseValue траты по категории House
     * @param shoppingValue траты по категории траты ао категории Shopping
     * @param entertainmentValue траты по категории Entertainment
     * @param otherValue траты по категории Other
     * @return возвращает лист с данными по категориям
     */
    public static List<String> collectData (
                                            int incomeValue,int foodValue,int houseValue,
                                            int shoppingValue, int transportValue,int entertainmentValue,
                                            int otherValue) {
        List<String> valuesAllCategory = new ArrayList<>();
        valuesAllCategory.add( "INCOME"+"="+incomeValue);
        valuesAllCategory.add("FOOD"+"="+foodValue);
        valuesAllCategory.add("HOUSE"+"="+houseValue);
        valuesAllCategory.add("SHOPPING"+"="+shoppingValue);
        valuesAllCategory.add("TRANSPORT"+"="+transportValue);
        valuesAllCategory.add("ENTERTAINMENT"+"="+entertainmentValue);
        valuesAllCategory.add("OTHER"+"="+otherValue);
        return valuesAllCategory;
    }
}
