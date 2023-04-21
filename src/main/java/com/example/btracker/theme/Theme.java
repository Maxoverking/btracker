package com.example.btracker.theme;

import java.util.List;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Theme {

  public static void theme(VBox mainContainer, CheckBox theme, List<Text> outputs) {
    mainContainer.setStyle("-fx-background-color:black");
    for (Text output:outputs) {
      if (theme.isSelected()) {
        output.setStyle("-fx-fill:white");
      } else {
        mainContainer.setStyle("");
        output.setStyle("-fx-fill:black");
      }
    }


  }

}
