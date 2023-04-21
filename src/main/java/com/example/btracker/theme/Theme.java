package com.example.btracker.theme;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class Theme {

    /**
     * Метод, меняющий цвет заливки окна приложения
     *
     * @param mainContainer окно приложения
     * @param theme         тема приложения
     * @param outputs       вывод цвета заливки
     */

    public static void theme(VBox mainContainer, CheckBox theme, List<Text> outputs) {
        mainContainer.setStyle("-fx-background-color:black");
        for (Text output : outputs) {
            if (theme.isSelected()) {
                output.setStyle("-fx-fill:white");
            } else {
                mainContainer.setStyle("");
                output.setStyle("-fx-fill:black");
            }
        }
    }
}
