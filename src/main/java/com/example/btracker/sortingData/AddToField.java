package com.example.btracker.sortingData;

import javafx.scene.text.Text;

public class AddToField {
    /**
     * Метод, выводящий данные после сортировки
     *
     * @param idx                 индекс
     * @param categories          категории
     * @param titleFood           название категории Food
     * @param titleHouse          название категории House
     * @param titleShopping       название категории Shopping
     * @param titleTransport      название категории Transport
     * @param titleEntertainment  название категории Entertainment
     * @param titleOther          название категории Other
     * @param outputFood          расходы по категории Food
     * @param outputHouse         расходы по категории House
     * @param outputShopping      расходы по категории Shopping
     * @param outputTransport     расходы по категории Transport
     * @param outputEntertainment расходы по категории Entertainment
     * @param outputOther         расходы по категории
     */

    public static void addToField(int idx, String categories,
                                  Text titleFood, Text titleHouse, Text titleShopping,
                                  Text titleTransport, Text titleEntertainment, Text titleOther,
                                  Text outputFood, Text outputHouse, Text outputShopping,
                                  Text outputTransport, Text outputEntertainment, Text outputOther) {

        String[] parts = categories.split("=");

        String category = parts[0]; // Получаем название переменной

        String expenses = parts[1]; // Получаем значение переменной
        switch (idx) {
            case 0 -> {
                titleFood.setText(category);
                outputFood.setText(expenses + " € ");
            }
            case 1 -> {
                titleHouse.setText(category);
                outputHouse.setText(expenses + " € ");
            }
            case 2 -> {
                titleShopping.setText(category);
                outputShopping.setText(expenses + " € ");
            }
            case 3 -> {
                titleTransport.setText(category);
                outputTransport.setText(expenses + " € ");
            }
            case 4 -> {
                titleEntertainment.setText(category);
                outputEntertainment.setText(expenses + " € ");
            }
            case 5 -> {
                titleOther.setText(category);
                outputOther.setText(expenses + " € ");
            }
            default -> {
            }
        }
    }
}
