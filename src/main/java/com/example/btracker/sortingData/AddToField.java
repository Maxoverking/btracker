package com.example.btracker.sortingData;

import javafx.scene.text.Text;

public class AddToField {

    public static void addToField(int idx, String categories,
                                  Text titleFood, Text titleHouse, Text titleShopping,
                                  Text titleTransport, Text titleEntertainment, Text titleOther,
                                  Text outputFood, Text outputHouse, Text outputShopping,
                                  Text outputTransport, Text outputEntertainment, Text outputOther) {

        String[] parts = categories.split("=");
// Получаем название переменной
        String category = parts[0];
// Получаем значение переменной
        String expenses = parts[1];
        switch (idx) {
            case 0 -> {
                titleFood.setText(category);
                outputFood.setText(expenses);
            }
            case 1 -> {
                titleHouse.setText(category);
                outputHouse.setText(expenses);
            }
            case 2 -> {
                titleShopping.setText(category);
                outputShopping.setText(expenses);
            }
            case 3 -> {
                titleTransport.setText(category);
                outputTransport.setText(expenses);
            }
            case 4 -> {
                titleEntertainment.setText(category);
                outputEntertainment.setText(expenses);
            }
            case 5 -> {
                titleOther.setText(category);
                outputOther.setText(expenses);
            }
            default -> {
            }
        }
    }
}
