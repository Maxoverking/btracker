package com.example.btracker.sortingData;

import javafx.scene.text.Text;

public class AddToField {

  public static void addToField(int idx ,String  categories,
      Text titleFood,Text  titleHouse,Text titleShopping,
      Text titleTransport,Text titleEntertainment,Text titleOther,
      Text outputFood, Text outputHouse,Text outputShopping,
      Text outputTransport,Text outputEntertainment,Text outputOther) {

    String[] parts = categories.split("=");

// Получаем название переменной
    String category = parts[0];

// Получаем значение переменной
    String expencies = parts[1];
    switch (idx) {
      case 0 -> {
        titleFood.setText(category);
        outputFood.setText(expencies);
      }
      case 1 -> {
        titleHouse.setText(category);
        outputHouse.setText(expencies);
        ;
      }
      case 2 -> {
        titleShopping.setText(category);
        outputShopping.setText(expencies);
        ;
      }
      case 3 -> {
        titleTransport.setText(category);
        outputTransport.setText(expencies);
        ;
      }
      case 4 -> {
        titleEntertainment.setText(category);
        outputEntertainment.setText(expencies);
        ;
      }
      case 5 -> {
        titleOther.setText(category);
        outputOther.setText(expencies);
        ;
      }
      default -> {
      }
    }
  }

}
