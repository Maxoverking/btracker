package com.example.btracker.sameOperation;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class OperationBtnsMonths {

  public static void operationWithButtonsMonth (Button buttonShow,Button buttonMonth, Text outputError,
      TextField inputMonth){
    buttonShow.setText("Show");
    buttonShow.setVisible(true);
    buttonMonth.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
    inputMonth.setText("");
    buttonMonth.setDisable(false);
  }
  public static void showButtonsMonth (Button buttonShow,Button buttonMonth){
    buttonMonth.setDisable(false);
    buttonMonth.setStyle("");

  }

}
