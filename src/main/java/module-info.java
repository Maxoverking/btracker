module com.example.btracker {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.btracker to javafx.fxml;
  exports com.example.btracker;
  exports com.example.btracker.allClasses;
  opens com.example.btracker.allClasses to javafx.fxml;
}