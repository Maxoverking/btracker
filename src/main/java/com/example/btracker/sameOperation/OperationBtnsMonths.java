package com.example.btracker.sameOperation;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class OperationBtnsMonths {

    public static void operationWithButtonsMonth(Button buttonShow, Button buttonMonth, Text outputError,
                                                 TextField inputMonth) {
        outputError.setText("");
        inputMonth.setText("");
        buttonShow.setText("Show");
        buttonShow.setVisible(true);
        buttonMonth.setStyle("-fx-background-color: #FF8034;");
        buttonMonth.setDisable(false);
    }

    public static void showButtonsMonth(Button buttonMonth, Text sortText, Button btnSortUp,
                                        Button sortDown) {
        buttonMonth.setDisable(false);
        buttonMonth.setStyle("");
        sortText.setVisible(true);
        btnSortUp.setVisible(true);
        sortDown.setVisible(true);
        btnSortUp.setText("↑");
        sortDown.setText("↓");
    }
}
