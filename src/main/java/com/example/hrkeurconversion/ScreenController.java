package com.example.hrkeurconversion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class ScreenController {

    @FXML
    public void showConversionScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(ConversionApplication.class.getResource("mainScreen.fxml"));
        Scene scene = null;

        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ConversionApplication.getStage().setScene(scene);
        ConversionApplication.getStage().show();
    }

    @FXML
    public void showCalculatorScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(ConversionApplication.class.getResource("calculatorScreen.fxml"));
        Scene scene = null;

        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ConversionApplication.getStage().setScene(scene);
        ConversionApplication.getStage().show();
    }

}
