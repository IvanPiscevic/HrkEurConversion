package com.example.hrkeurconversion;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalculatorController {

    @FXML
    VBox containerVbox;

    @FXML
    TextField tenCentField;

    @FXML
    TextField twentyCentField;

    @FXML
    TextField fiftyCentField;

    @FXML
    TextField oneEuroField;

    @FXML
    TextField twoEuroField;

    @FXML
    TextField fiveEuroField;

    @FXML
    TextField tenEuroField;

    @FXML
    TextField twentyEuroField;


    @FXML
    TextField resultField;


    @FXML
    public EventHandler<KeyEvent> eventHandlerSumAmountTextField = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {

            calculateAmount(tenCentField, twentyCentField, fiftyCentField,
                    oneEuroField, twoEuroField, fiveEuroField, tenEuroField, twentyEuroField);

        }
    };

    @FXML
    private void initialize() {

        // Result field isn't allowed to be modified directly
        resultField.setEditable(false);
        resultField.setFocusTraversable(false);

        tenCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twentyCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        fiftyCentField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        oneEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twoEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        fiveEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        tenEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);
        twentyEuroField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerSumAmountTextField);


        // Enter Button HotKey -> ENTER
        tenCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tenCentField.setFocusTraversable(false);
                twentyCentField.requestFocus();
            }
        });

        twentyCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twentyCentField.setFocusTraversable(false);
                fiftyCentField.requestFocus();
            }
        });

        fiftyCentField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fiftyCentField.setFocusTraversable(false);
                oneEuroField.requestFocus();
            }
        });

        oneEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                oneEuroField.setFocusTraversable(false);
                twoEuroField.requestFocus();
            }
        });

        twoEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twoEuroField.setFocusTraversable(false);
                fiveEuroField.requestFocus();
            }
        });

        fiveEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fiveEuroField.setFocusTraversable(false);
                tenEuroField.requestFocus();
            }
        });

        tenEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tenEuroField.setFocusTraversable(false);
                twentyEuroField.requestFocus();
            }
        });

        twentyEuroField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                twentyEuroField.setFocusTraversable(false);
                tenCentField.requestFocus();
            }
        });
    }

    @FXML
    public void onResetButtonPress() {
        tenCentField.setText(""); twentyCentField.setText(""); fiftyCentField.setText("");
        oneEuroField.setText(""); twoEuroField.setText(""); fiveEuroField.setText("");
        tenEuroField.setText(""); twentyEuroField.setText("");
        resultField.setText("");

        tenCentField.requestFocus();
    }

    private void calculateAmount(TextField tenCentField, TextField twentyCentField, TextField fiftyCentField,
                                 TextField oneEuroField, TextField twoEuroField, TextField fiveEuroField,
                                 TextField tenEuroField, TextField twentyEuroField) {

        double sumAmount = 0D;

        double tenCentAmount = 0D;
        double twentyCentAmount = 0D;
        double fiftyCentAmount = 0D;
        double oneEuroAmount = 0D;
        double twoEuroAmount = 0D;
        double fiveEuroAmount = 0D;
        double tenEuroAmount = 0D;
        double twentyEuroAmount = 0D;

        if (!tenCentField.getText().isBlank()) {
            tenCentAmount = (10 * Double.parseDouble(tenCentField.getText())) / 100;
        }
        if (!twentyCentField.getText().isBlank()) {
            twentyCentAmount = (20 * Double.parseDouble(twentyCentField.getText())) / 100;
        }
        if (!fiftyCentField.getText().isBlank()) {
            fiftyCentAmount = (50 * Double.parseDouble(fiftyCentField.getText())) / 100;
        }
        if (!oneEuroField.getText().isBlank()) {
            oneEuroAmount = Double.parseDouble(oneEuroField.getText());
        }
        if (!twoEuroField.getText().isBlank()) {
            twoEuroAmount = (2 * Double.parseDouble(twoEuroField.getText()));
        }
        if (!fiveEuroField.getText().isBlank()) {
            fiveEuroAmount = (5 * Double.parseDouble(fiveEuroField.getText()));
        }
        if (!tenEuroField.getText().isBlank()) {
            tenEuroAmount = (10 * Double.parseDouble(tenEuroField.getText()));
        }
        if (!twentyEuroField.getText().isBlank()) {
            twentyEuroAmount = (20 * Double.parseDouble(twentyEuroField.getText()));
        }

        sumAmount += tenCentAmount += twentyCentAmount +=
                fiftyCentAmount += oneEuroAmount += twoEuroAmount += fiveEuroAmount += tenEuroAmount +=
                        twentyEuroAmount;


        resultField.setText(Double.toString(round(sumAmount, 2)));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
