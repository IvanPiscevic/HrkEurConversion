package com.example.hrkeurconversion;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ConversionController {

    private final static Double ZERO_VALUE = 0D;
    private final static Double EURO_VALUE = 7.53450D;

    @FXML
    public TextField receiptAmountEURTextField;

    @FXML
    public TextField receiptAmountHRKTextField;

    @FXML
    public TextField givenAmountTextField;

    @FXML
    public TextField returnAmountEURTextField;

    @FXML
    public TextField returnAmountHRKTextField;

    @FXML
    public EventHandler<KeyEvent> eventHandlerReceiptAmountTextField = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {

            if (!receiptAmountEURTextField.getText().isBlank()) {
                calculateReturnAmount(receiptAmountEURTextField, givenAmountTextField);

                String receiptEURAmountString = receiptAmountEURTextField.getText();

                if (receiptAmountEURTextField.getText().contains(",")) {
                    receiptEURAmountString = receiptEURAmountString.replace(',', '.');
                }

                double receiptHRK = round(Double.parseDouble(receiptEURAmountString) * EURO_VALUE, 2);
                receiptAmountHRKTextField.setText(String.valueOf(receiptHRK));
            }
        }
    };

    @FXML
    public EventHandler<KeyEvent> eventHandlerGivenAmountTextField = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {

            if (!givenAmountTextField.getText().isBlank()) {
                calculateReturnAmount(receiptAmountEURTextField, givenAmountTextField);
            }
        }
    };

    @FXML
    public void initialize() {

        receiptAmountEURTextField.setText("0"); receiptAmountHRKTextField.setText("0"); givenAmountTextField.setText("0");

        // Event Listener initialization
        receiptAmountEURTextField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerReceiptAmountTextField);
        givenAmountTextField.addEventHandler(KeyEvent.KEY_RELEASED, eventHandlerGivenAmountTextField);

        returnAmountEURTextField.setEditable(false);
        returnAmountEURTextField.setFocusTraversable(false);

        returnAmountHRKTextField.setEditable(false);
        returnAmountHRKTextField.setFocusTraversable(false);

        // Enter Button HotKey -> ENTER
        receiptAmountEURTextField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                receiptAmountEURTextField.setFocusTraversable(false);
                givenAmountTextField.requestFocus();
            }
        });

        givenAmountTextField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                givenAmountTextField.setFocusTraversable(false);
                receiptAmountEURTextField.requestFocus();
            }
        });

        // Reset Button Hotkey -> R
//        receiptAmountTextField.setOnKeyPressed(event -> {
//            if (event.getCode().equals(KeyCode.R)) {
//                receiptAmountTextField.setFocusTraversable(false);
//                onResetButtonPress();
//            }
//        });
//
//        givenAmountTextField.setOnKeyPressed(event -> {
//            if (event.getCode().equals(KeyCode.R)) {
//                givenAmountTextField.setFocusTraversable(false);
//                onResetButtonPress();
//            }
//        });
    }

    @FXML
    public void onResetButtonPress() {
        receiptAmountEURTextField.clear();
        receiptAmountHRKTextField.clear();
        givenAmountTextField.clear();
        returnAmountEURTextField.clear();
        returnAmountHRKTextField.clear();

        receiptAmountEURTextField.requestFocus();
    }

    private void calculateReturnAmount(TextField receiptAmountTextField, TextField givenAmountTextField) {

        String receiptAmountString = receiptAmountTextField.getText();
        String givenAmountString = givenAmountTextField.getText();

        if (receiptAmountString.contains(",")) {
            receiptAmountString = receiptAmountString.replace(',', '.');
        }

        if (givenAmountString.contains(",")) {
            givenAmountString = givenAmountString.replace(',', '.');
        }

        double receiptAmount = 0D;
        Double givenAmount = Double.parseDouble(givenAmountString);
        double returnAmount;

        if (!receiptAmountTextField.getText().isBlank()) {
            receiptAmount = Double.parseDouble(receiptAmountString);
        }

        if (!givenAmountTextField.getText().isBlank()) {
            givenAmount = Double.parseDouble(givenAmountString);
        }

        if (givenAmount.equals(ZERO_VALUE)) {
            returnAmountEURTextField.setText("0");
            returnAmountHRKTextField.setText("0");
        } else if (receiptAmount > givenAmount / EURO_VALUE) {
            returnAmountEURTextField.setText("-");
            returnAmountHRKTextField.setText("-");
        } else {
            returnAmount = round((((givenAmount / EURO_VALUE) - receiptAmount)), 2);
            returnAmountEURTextField.setText(Double.toString(returnAmount));
            returnAmount = round(returnAmount * EURO_VALUE, 2);
            returnAmountHRKTextField.setText(Double.toString(returnAmount));
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}