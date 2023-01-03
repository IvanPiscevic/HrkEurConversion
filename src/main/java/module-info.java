module com.example.hrkeurconversion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hrkeurconversion to javafx.fxml;
    exports com.example.hrkeurconversion;
}